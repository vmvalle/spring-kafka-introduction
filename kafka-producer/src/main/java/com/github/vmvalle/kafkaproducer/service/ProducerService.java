package com.github.vmvalle.kafkaproducer.service;

import com.github.vmvalle.dto.User;
import org.apache.kafka.clients.producer.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;


@Service
public class ProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    @Qualifier("producer")
    private KafkaProducer<String, String> kafkaProducer;

    @Value("${kafka.topic}")
    private String topic;

    public void sendUsername(User user) {

        LOGGER.info("Sending user.name='{}' to Kafka...", user.getName());
        kafkaProducer.send(new ProducerRecord<>(topic, user.getName()), (recordMetadata, e) -> {
            if (e != null) {
                LOGGER.error("Something bad happened", e);
            }
        });
    }
}
