package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class JavaConfigDemoApp {

	public static void main(String[] args) {
		
		//Read spring config java class
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get the bean from the spring container by using default Bean ID
		Coach theCoach = context.getBean("swimCoach",Coach.class);
		
		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		// Call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Close the container
		context.close();
	}

}
