package com.github.vmvalle.kafkaproducer.service;

import com.twitter.hbc.core.Client;
import com.twitter.hbc.httpclient.BasicClient;
import org.apache.kafka.clients.producer.KafkaProducer;
import org.apache.kafka.clients.producer.ProducerRecord;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Service
public class TwitterProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    @Qualifier("producer")
    private KafkaProducer<String, String> kafkaProducer;

    @Autowired
    @Qualifier("twitterClient")
    private BasicClient twitterClient;

    @Autowired
    @Qualifier("msgQueueTwitter")
    private BlockingQueue<String> msgQueueTwitter;

    @Value("${kafka.topic.tweets}")
    private String topic;

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void sendTweetsToKafka() {

        for (int msgRead = 0; msgRead < 10; msgRead++) {
            if (twitterClient.isDone()) {
                System.out.println("Client connection closed unexpectedly: " + twitterClient.getExitEvent().getMessage());
                break;
            }

            String msg = null;
            try {
                msg = msgQueueTwitter.poll(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                e.printStackTrace();
                twitterClient.stop();
            }
            if (msg != null){
                LOGGER.info(msg);
                kafkaProducer.send(new ProducerRecord<>("tweets", null, msg), (recordMetadata, e) -> {
                    if (e != null) {
                        LOGGER.error("Something bad happened", e);
                    }
                });
            }
        }

        //twitterClient.stop();

        // Print some stats
        LOGGER.info("The client read {} messages!", twitterClient.getStatsTracker().getNumMessages());

    }
}
