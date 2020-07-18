package demo.hadoop.hbase.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * ES配置类
 */
@Component
@ConfigurationProperties(prefix = "wind.elasticsearch")
public class EsProperties {

	private String   clusterName;
	private String clusterNodes;
	private String esDataUrl;

	public String getClusterName() {
		return clusterName;
	}

	public void setClusterName(String clusterName) {
		this.clusterName = clusterName;
	}

	public String getClusterNodes() {
		return clusterNodes;
	}

	public void setClusterNodes(String clusterNodes) {
		this.clusterNodes = clusterNodes;
	}

	public String getEsDataUrl() {
		return esDataUrl;
	}

	public void setEsDataUrl(String esDataUrl) {
		this.esDataUrl = esDataUrl;
	}

}
