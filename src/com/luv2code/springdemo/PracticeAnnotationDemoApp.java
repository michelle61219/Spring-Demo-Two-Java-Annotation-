package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class PracticeAnnotationDemoApp {

	public static void main(String[] args) {
		// Load the config file from spring
		ClassPathXmlApplicationContext context =new ClassPathXmlApplicationContext("applicationContext.xml");
		
		/*
		 * Coach theCoach = context.getBean("thatSillyCoach",Coach.class);
		 * This is for explicit Bean ID.
		 */
		
		// Get the bean from the spring container by using default Bean ID
		Coach theCoach = context.getBean("pingPongCoach",Coach.class);
		
		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		// Call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Close the container
		context.close();
	}

}
