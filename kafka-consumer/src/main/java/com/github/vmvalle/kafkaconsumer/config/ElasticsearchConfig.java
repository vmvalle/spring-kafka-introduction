package com.github.vmvalle.kafkaconsumer.config;

import org.apache.http.HttpHost;
import org.elasticsearch.action.bulk.BulkProcessor;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestClient;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.TransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.data.elasticsearch.ElasticsearchProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PreDestroy;
import java.io.IOException;
import java.net.InetAddress;
import java.net.InetSocketAddress;
import java.net.UnknownHostException;

@Configuration
public class ElasticsearchConfig {

    private static final Logger LOGGER = LoggerFactory.getLogger(ElasticsearchConfig.class);


    @Value("${elasticsearch.host:localhost}")
    public String host;

    @Value("${elasticsearch.port:9200}")
    public int port;

    @Bean(destroyMethod = "close")
    public RestHighLevelClient client() {
        RestHighLevelClient client = new RestHighLevelClient(
                RestClient.builder(new HttpHost(host, port, "http")));
        return client;
    }


}
