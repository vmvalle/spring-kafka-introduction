package com.github.vmvalle.kafkaproducer.service;

import com.twitter.hbc.httpclient.BasicClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;

import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;

@Service
public class TwitterProducer {

    private static final Logger LOGGER = LoggerFactory.getLogger(TwitterProducer.class);

    @Autowired
    private KafkaTemplate<String,String> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    @Autowired
    private BasicClient twitterClient;

    @Autowired
    private BlockingQueue<String> msgQueueTwitter;

    @Scheduled(fixedDelayString = "${fixedDelay.in.milliseconds}")
    public void sendTweetsToKafka() {

        for (int msgRead = 0; msgRead < 10; msgRead++) {
            if (twitterClient.isDone()) {
                System.out.println("Client connection closed by: "
                        + twitterClient.getExitEvent().getMessage());
                break;
            }

            String msg = null;
            try {
                msg = msgQueueTwitter.poll(5, TimeUnit.SECONDS);
            } catch (InterruptedException e) {
                LOGGER.error("An exception ocurred!", e);
                twitterClient.stop();
            }
            if (msg != null){
                LOGGER.info(msg);
                kafkaTemplate.send(topic, msg);
            }
        }

        LOGGER.info("The client read {} messages!", twitterClient.getStatsTracker().getNumMessages());
    }
}


