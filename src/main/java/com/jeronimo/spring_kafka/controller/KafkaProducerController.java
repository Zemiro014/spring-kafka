package com.jeronimo.spring_kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeronimo.spring_kafka.service.KafkaProducerService;

@RestController
@RequestMapping(value = "/kafka")
public class KafkaProducerController {

	private final KafkaProducerService producerService;
	 
    @Autowired
    public KafkaProducerController(KafkaProducerService producerService) 
    {
        this.producerService = producerService;
    }
 
    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) 
    {
        this.producerService.sendMessage(message);
    }
}
