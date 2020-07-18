package demo.hadoop.hbase.controller;

import demo.hadoop.hbase.framework.Response;
import demo.hadoop.hbase.service.QueryService;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedInputStream;
import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.net.URLEncoder;
import java.util.Map;


/**
 *
 */
@Controller
public class HbaseController {

    /**
     *
     */
    @Autowired
    private QueryService queryService;


    @GetMapping("/getByOriIdAndTable")
    @ResponseBody
    public Response getByOriIdAndTable(
            @ApiParam(defaultValue = "56315970")
            @RequestParam String oriId,
            @ApiParam(defaultValue = "origin_raw_gsj_usa")
            @RequestParam String tableName) {
        Map map = queryService.queryHBase(oriId, tableName);
        return Response.Ok(map);
    }

    @PostMapping(value = "/download")
    @ResponseBody
    public String downloadFile(HttpServletRequest request,
                               HttpServletResponse response) throws Exception {
        String rowkey = request.getParameter("id");
        String fileName = request.getParameter("FileName");
        String TableName = request.getParameter("TableName");

        byte[] map = queryService.queryHBaseByRowKey(rowkey, TableName);
        // 配置文件下载
        response.setContentType("application/force-download");
        // 下载文件能正常显示中文
        response.setHeader("Content-Disposition", "attachment;filename=" + URLEncoder.encode(fileName, "UTF-8"));
        // 实现文件下载
        byte[] buffer = new byte[1024];
        try (BufferedInputStream bis = new BufferedInputStream(new ByteArrayInputStream(map))) {
            OutputStream os = response.getOutputStream();
            int i = bis.read(buffer);
            while (i != -1) {
                os.write(buffer, 0, i);
                i = bis.read(buffer);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        return null;
    }
}
