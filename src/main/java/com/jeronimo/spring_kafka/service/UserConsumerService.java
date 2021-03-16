package com.jeronimo.spring_kafka.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import com.jeronimo.spring_kafka.model.AppConstants;
import com.jeronimo.spring_kafka.model.User;

@Service
public class UserConsumerService {
	private static final Logger logger = LoggerFactory.getLogger(UserConsumerService.class);

	@KafkaListener(topics = AppConstants.TOPIC_NAME_USER_LOG, groupId = AppConstants.GROUP_ID)
	public void consume(User user) {
		logger.info(String.format("User created -> %s", user));
	}
}
