package com.luv2code.springdemo;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

//@Component("thatSillyCoach") <-- Explicit Bean ID 

@Component // Use the default Bean ID = tennisCoach
//@Scope("prototype") // Create a different instance every time (Calling constructor twice)
public class TennisCoach implements Coach {
	
	
	private FortuneService fortuneService;

	// Define a default constructor (Use with the Setter Method)
	public TennisCoach() {
		System.out.println("TennisCoach: inside of default constructor");
	}
	
	// Define my init method
	@PostConstruct
	public void doMyStartupStuff() {
		System.out.println(">> TennisCoach inside of doMyStartUpStuff()");
		
	}
	
	// Define my destroy method
	@PreDestroy
	public void doMyClearnUpStuff() {
		System.out.println(">> TennisCoach inside of doMyCleanUpStuff()");
	}
	
	
	/*
	 * This is for Constructor Injection
	 * @Qualifier : Pick which bean to use
	 */
	@Autowired
	public TennisCoach(@Qualifier("randomFortuneService") FortuneService fortuneService) {
		System.out.println("TennisCoach: inside of constructor using @autowired and @qualifier");
		this.fortuneService = fortuneService;
	}
	
	/*
	 * This is for Setter Injection
	 *  
	 * // Define a setter method
	 * @Autowired public void setFortuneService(FortuneService fortuneService) {
	 * System.out.println("TennisCoach: inside of setFortuneService() method ");
	 * this.fortuneService = fortuneService; }
	 * 
	 * This is for Method Injection
	 * @Autowired public void doSomeCrazyStuff(FortuneService fortuneService) {
	 * System.out.println("TennisCoach: inside of doSomeCrazyStuff() method ");
	 * this.fortuneService = fortuneService; }
	 */

	@Override
	public String getDailyWorkout() {
		return "Practice your backhand volley";
	}

	@Override
	public String getDailyFortune() {
		return fortuneService.getFortune();
	}

}
