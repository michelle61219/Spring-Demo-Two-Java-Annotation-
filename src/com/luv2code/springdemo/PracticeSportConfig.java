package com.luv2code.springdemo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PracticeSportConfig {

	@Bean
	public FortuneService happyFortuneService() {
		return new HappyFortuneService();
	}
	
	@Bean
	public Coach wrestlingCoach() {
		WrestlingCoach wrestlingCoach = new WrestlingCoach(happyFortuneService());
		return wrestlingCoach;
	}
}
