package com.vagade.microservices.kafkaservice.controller;

import com.vagade.microservices.kafkaservice.messaging.Producer;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaController {

    private final Producer producer;

    @Autowired
    KafkaController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish/message/{message}")
    public void sendMessageToKafkaTopic(@PathVariable("message") String message) {
        this.producer.sendMessage(message);
    }
}
