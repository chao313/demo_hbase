package demo.hadoop.hbase.model;

import java.util.List;

/**
 * Project: bootstrap-demo
 * Created by Zhangdd on 2019/2/27.
 */
public class ResultEntity<T> {
    private long total;
    private List<T> rows;

    public ResultEntity() {
    }

    public long getTotal() {
        return total;
    }

    public void setTotal(long total) {
        this.total = total;
    }

    public List<T> getRows() {
        return rows;
    }

    public void setRows(List<T> rows) {
        this.rows = rows;
    }
}
