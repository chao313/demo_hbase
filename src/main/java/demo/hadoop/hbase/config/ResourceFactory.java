package demo.hadoop.hbase.config;

import org.apache.hadoop.hbase.HBaseConfiguration;
import org.apache.hadoop.hbase.client.Connection;
import org.apache.hadoop.hbase.client.ConnectionFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.Map;


@Component
public class ResourceFactory {

    private Logger LOGGER = LoggerFactory.getLogger(ResourceFactory.class);

    @Autowired
    private HBaseConfig hBaseConfig;

    @Bean(name = "hbaseConn")
    public Connection getHbaseConfiguration() {
        org.apache.hadoop.conf.Configuration conf = HBaseConfiguration.create();
        for (Map.Entry<Object, Object> entry : hBaseConfig.getConfig().entrySet()) {
            conf.set(entry.getKey().toString(), entry.getValue().toString());
        }

        Connection connection = null;
        try {
            connection = ConnectionFactory.createConnection(conf);
        } catch (Exception e) {
            LOGGER.error("", e);
        }

        if (connection == null) {
            LOGGER.error("无法创建Hbase连接，服务即将退出");
            System.exit(0);
        }

        return connection;
    }


}
