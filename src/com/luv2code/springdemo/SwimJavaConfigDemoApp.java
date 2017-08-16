package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class SwimJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//Read spring config java class
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(SportConfig.class);
		
		// Get the bean from the spring container by using default Bean ID (Use when the actual values are provided on txt file)
		SwimCoach theCoach = context.getBean("swimCoach",SwimCoach.class);
		
		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		// Call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
		// Call our new swim methods...has the prop values injected
		System.out.println("Email: " + theCoach.getEmail());
		System.out.println("Team: " + theCoach.getTeam());
		
		// Close the container
		context.close();
	}

}
