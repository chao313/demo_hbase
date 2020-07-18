package demo.hadoop.hbase.model;

import java.util.List;

/**
 * @author lzhu.john
 * @version V1.0
 * @Package cn.com.wind.model
 * @Description: TODO
 * @date 2019/5/29 16:11
 */
public class Page<T> {

    private long total;
    private List<T> records;

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRecords() {
        return records;
    }

    public void setRecords(List<T> records) {
        this.records = records;
    }
}


