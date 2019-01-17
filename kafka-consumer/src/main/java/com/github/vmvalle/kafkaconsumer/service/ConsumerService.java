package com.github.vmvalle.kafkaconsumer.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.github.vmvalle.dto.User;

@Service
public class ConsumerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ConsumerService.class);

    /**
     * Receive the user object sent by a kafka producer to the topic subscribed
     * @param user User sent by a kafka producer
     */
    @KafkaListener(topics = "${kafka.topic}")
    public void receive(User user) {
        LOGGER.info("Received user: " + user.toString());
    }

}
