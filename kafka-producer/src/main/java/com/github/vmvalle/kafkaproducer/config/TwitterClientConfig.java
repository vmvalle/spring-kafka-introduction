package com.github.vmvalle.kafkaproducer.config;

import com.google.common.collect.Lists;
import com.twitter.hbc.ClientBuilder;
import com.twitter.hbc.core.Client;
import com.twitter.hbc.core.Constants;
import com.twitter.hbc.core.Hosts;
import com.twitter.hbc.core.HttpHosts;
import com.twitter.hbc.core.endpoint.StatusesFilterEndpoint;
import com.twitter.hbc.core.processor.StringDelimitedProcessor;
import com.twitter.hbc.httpclient.BasicClient;
import com.twitter.hbc.httpclient.auth.Authentication;
import com.twitter.hbc.httpclient.auth.OAuth1;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.List;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.LinkedBlockingQueue;

@Configuration
public class TwitterClientConfig {

    String consumerKey = "SleaNjEbbHaAwUuQR4GqKkraZ";
    String consumerSecret = "8shHJHXTvFNSq6ODdp3KXJovE1DMFy1nFJ7GU9q0mSpztwbcMy";
    String token = "1119626009039519744-pJgiObCqiP3D7iiygQEvvt10YnirZ8";
    String secret = "VSiLOqFmihwLdYRKFGe9OcCDyAMJ7DkVC1WcH1X1yBZxi";

    List<String> terms = Lists.newArrayList("NFL", "NBA");

    BlockingQueue<String> msgQueue = new LinkedBlockingQueue<>(1000);

    @Bean(name = "twitterClient")
    public BasicClient createTwitterClient(){

        StatusesFilterEndpoint endpoint = new StatusesFilterEndpoint();
        endpoint.trackTerms(terms);
        endpoint.stallWarnings(false);

        // These secrets should be read from a config file
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
