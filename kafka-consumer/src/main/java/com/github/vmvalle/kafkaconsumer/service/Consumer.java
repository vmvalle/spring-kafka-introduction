package com.github.vmvalle.kafkaconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class Consumer {

    private static final Logger LOGGER = LoggerFactory.getLogger(Consumer.class);

    @KafkaListener(topics = "${kafka.topic}")
    public void receive(String msg) {
        LOGGER.info("[Tweet: {}] Received notification request", msg);
    }

}
