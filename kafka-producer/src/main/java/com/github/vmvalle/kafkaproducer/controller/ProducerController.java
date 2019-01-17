package com.github.vmvalle.kafkaproducer.controller;

import com.github.vmvalle.dto.User;
import com.github.vmvalle.kafkaproducer.service.ProducerService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@RestController
@RequestMapping("/user")
public class ProducerController {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProducerController.class);

    @Autowired
    private ProducerService producerService;

    @PostMapping(value = "/new", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity processNotification(@RequestBody final User user) {
        try{
            LOGGER.info("Received request: {}", user);

            // Generate UUID
            final UUID uuid = UUID.randomUUID();
            user.setUuid(uuid);

            // Send message to kafka
            producerService.sendMessage(user);

            return new ResponseEntity<>(user, HttpStatus.OK);

        } catch (Exception e) {
            LOGGER.error("An error has occurred.", e);
            return new ResponseEntity<>(user, HttpStatus.INTERNAL_SERVER_ERROR);
        }

    }

}
