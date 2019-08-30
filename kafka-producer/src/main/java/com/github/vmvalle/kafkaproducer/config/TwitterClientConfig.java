package com.github.vmvalle.kafkaproducer.config;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.BasicClient;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Configuration
public class TwitterClientConfig {

    @Value("${twitter.consumer.key}")
    private String consumerKey;

    @Value("${twitter.consumer.secret}")
    private String consumerSecret;

    @Value("${twitter.token}")
    private String token;

    @Value("${twitter.secret}")
    private String secret;

    private List<String> terms = Lists.newArrayList("NBA", "NFL");

    private BlockingQueue<String> msgQueue = new LinkedBlockingQueue<>(1000);

    @Bean(name = "twitterClient")
    public BasicClient createTwitterClient(){

        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.trackTerms(terms);
        endpoint.stallWarnings(false);

        Authentication auth = new OAuth1(consumerKey, consumerSecret, token, secret);

        BasicClient client = new ClientBuilder()
                .name("TwitterClient")
                .hosts(Constants.STREAM_HOST)
                .authentication(auth)
                .endpoint(endpoint)
                .processor(new StringDelimitedProcessor(msgQueue))
                .build();

        client.connect();
        return client;
    }

    @Bean(name = "msgQueueTwitter")
    public BlockingQueue<String> createQueue(){
        return msgQueue;
    }

}
