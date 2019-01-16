package com.github.vmvalle.kafkaproducer.service;

import com.github.vmvalle.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;


@Service
public class ProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    public void sendMessage(User user) {
        LOGGER.info(String.format("#### -> Producing message -> %s", user.getName()));
        this.kafkaTemplate.send(topic, user);
    }
}
