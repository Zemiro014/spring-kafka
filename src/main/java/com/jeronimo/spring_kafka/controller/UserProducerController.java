package com.jeronimo.spring_kafka.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jeronimo.spring_kafka.model.User;
import com.jeronimo.spring_kafka.service.UserProducerService;

@RestController
@RequestMapping(value="/user")
public class UserProducerController {

	private final UserProducerService producerService;
	 
    @Autowired
    public UserProducerController(UserProducerService producerService) 
    {
        this.producerService = producerService;
    }
    
	@PostMapping(value = "/createUser")
	public void sendMessageToKafkaTopic(
	        @RequestParam("userId") long userId, 
	        @RequestParam("firstName") String firstName,
	        @RequestParam("lastName") String lastName) {
	     
	    User user = new User();
	    user.setUserId(userId);
	    user.setFirstName(firstName);
	    user.setLastName(lastName);
	     
	    this.producerService.saveCreateUserLog(user);
	}
}
