package demo.hadoop.hbase.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Map;


/**
 *
 */
@Service
public class QueryService {


    @Autowired
    private HbaseService hbaseService;

    public Map queryHBase(String oriId, String subIndexName) {
        return hbaseService.hbsearch(subIndexName, oriId);
    }

    public byte[] queryHBaseByRowKey(String rowKey, String tableNameValue) {
        return hbaseService.getAttach(tableNameValue, rowKey);
    }
}
