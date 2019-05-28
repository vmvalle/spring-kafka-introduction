package com.github.vmvalle.kafkastream.service;

import com.google.gson.JsonParser;
import org.apache.kafka.common.serialization.Serdes;
import org.apache.kafka.streams.StreamsBuilder;
import org.apache.kafka.streams.StreamsConfig;
import org.apache.kafka.streams.kstream.KStream;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.annotation.EnableKafkaStreams;
import org.springframework.kafka.annotation.KafkaStreamsDefaultConfiguration;
import org.springframework.kafka.config.KafkaStreamsConfiguration;

import java.util.HashMap;
import java.util.Map;

@Configuration
@EnableKafka
@EnableKafkaStreams
public class StreamProccess {

    private static JsonParser jsonParser = new JsonParser();

    @Bean(name = KafkaStreamsDefaultConfiguration.DEFAULT_STREAMS_CONFIG_BEAN_NAME)
    public KafkaStreamsConfiguration kStreamsConfigs() {
        Map<String, Object> props = new HashMap<>();
        props.put(StreamsConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        props.put(StreamsConfig.APPLICATION_ID_CONFIG, "testStreams");
        props.put(StreamsConfig.DEFAULT_KEY_SERDE_CLASS_CONFIG, Serdes.Integer().getClass().getName());
        props.put(StreamsConfig.DEFAULT_VALUE_SERDE_CLASS_CONFIG, Serdes.String().getClass().getName());
        return new KafkaStreamsConfiguration(props);
    }

    @Bean
    public KStream<Integer, String> kStream(StreamsBuilder kStreamBuilder) {
        KStream<Integer, String> stream = kStreamBuilder.stream("tweets");
        stream.filter((k, jsonTweet) ->  extractUserFollowersInTweet(jsonTweet) > 1000)
                .to("important_tweets");

        return stream;
    }


    private static Integer extractUserFollowersInTweet(String tweetJson){
        try {
            return jsonParser.parse(tweetJson)
                    .getAsJsonObject()
                    .get("user")
                    .getAsJsonObject()
                    .get("followers_count")
                    .getAsInt();
        }
        catch (NullPointerException e){
            return 0;
        }
    }
}
