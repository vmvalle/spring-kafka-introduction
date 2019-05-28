package com.github.vmvalle.kafkaconsumer.service;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.vmvalle.kafkaconsumer.model.Tweet;
import org.elasticsearch.action.index.IndexRequest;
import org.elasticsearch.action.index.IndexResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.client.RestHighLevelClient;
import org.elasticsearch.common.xcontent.XContentType;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @Autowired
    private RestHighLevelClient client;

    @KafkaListener(topics = "${kafka.topic}")
    public void receive(String tweetJson) {

        LOGGER.info("[Tweet: {}] Received notification request", tweetJson);

        Tweet tweet = jsonToTweet(tweetJson);

        IndexRequest request = new IndexRequest("twitter", "tweets", tweet.getId().toString());
        request.source(tweetJson, XContentType.JSON);

        try {
            IndexResponse indexResponse = client.index(request);
            LOGGER.info("Response ElasticSearch status: {}, TweetId: {}", indexResponse.status(), tweet.getId());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    private static Tweet jsonToTweet(String tweetJson) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.enable(DeserializationFeature.ACCEPT_EMPTY_STRING_AS_NULL_OBJECT);
        Tweet tweet = null;
        try {
            tweet = objectMapper.readValue(tweetJson, Tweet.class);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return tweet;
    }

}
