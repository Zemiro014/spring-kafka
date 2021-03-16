package com.jeronimo.spring_kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.jeronimo.spring_kafka.model.AppConstants;
import com.jeronimo.spring_kafka.model.User;

@Service
public class UserProducerService {
	private static final Logger logger = LoggerFactory.getLogger(UserProducerService.class);
	
	@Autowired
	private KafkaTemplate<String, Object> kafkaTemplate;
	 
	public void saveCreateUserLog(User user) 
	{
	    logger.info(String.format("User created -> %s", user));
	    this.kafkaTemplate.send(AppConstants.TOPIC_NAME_USER_LOG, user);
	}
}
