package com.github.vmvalle.kafkaproducer.service;

import com.github.vmvalle.dto.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;
import org.springframework.util.concurrent.ListenableFuture;
import org.springframework.util.concurrent.ListenableFutureCallback;


@Service
public class ProducerService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerService.class);

    @Autowired
    private KafkaTemplate<String, User> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    public void sendMessage(User user) {

        LOGGER.info(String.format("#### -> Producing message -> %s", user.toString()));
        ListenableFuture<SendResult<String, User>> future = kafkaTemplate.send(topic, user);
        future.addCallback(new ListenableFutureCallback<SendResult<String, User>>() {

            @Override
            public void onSuccess(SendResult<String, User> result) {
                System.out.println("Sent message=[" + user.toString() + "] with offset=[" + result.getRecordMetadata().offset() + "]");
            }
            @Override
            public void onFailure(Throwable ex) {
                System.out.println("Unable to send message=[" + user.toString() + "] due to : " + ex.getMessage());
            }
        });
    }
}
