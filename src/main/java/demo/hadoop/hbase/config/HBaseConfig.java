package demo.hadoop.hbase.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

import java.util.Properties;

/**
 * @author lzhu.john
 * @version V1.0
 * @Package cn.com.wind.importdb.core.config
 * @Description: TODO
 * @date 2019/4/25 17:21
 */
@Component
@ConfigurationProperties(prefix = "wind.hbase")
public class HBaseConfig {

    private Logger LOGGER = LoggerFactory.getLogger(HBaseConfig.class);

    private Properties config;

    public Properties getConfig() {
        return config;
    }

    public void setConfig(Properties config) {
        this.config = config;
    }
}
