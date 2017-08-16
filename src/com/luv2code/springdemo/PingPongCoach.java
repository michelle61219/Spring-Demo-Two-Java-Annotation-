package com.luv2code.springdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

@Component
public class PingPongCoach implements Coach {

	@Autowired
	@Qualifier("fileFortuneService")
	private FortuneService fortuneService;

	// Define a default constructor
	public PingPongCoach() {
		System.out.println("PingPongCoach: inside of default constructor");
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Do Ping Pong Practice";
	}

	@Override
	public String getDailyFortune() {
		
		return fortuneService.getFortune();
	}

}
