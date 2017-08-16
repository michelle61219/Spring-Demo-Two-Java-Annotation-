package com.luv2code.springdemo;

public class WrestlingCoach implements Coach {

	private FortuneService fortuneService;
	
	public WrestlingCoach(FortuneService fortuneService) {
		this.fortuneService = fortuneService;
	}
	
	@Override
	public String getDailyWorkout() {
		
		return "Do wrestling";
	}

	@Override
	public String getDailyFortune() {
	
		return fortuneService.getFortune();
	}

}
