package com.luv2code.springdemo;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class PracticeJavaConfigDemoApp {

	public static void main(String[] args) {
		
		//Read spring config java class
		AnnotationConfigApplicationContext context =new AnnotationConfigApplicationContext(PracticeSportConfig.class);
		
		// Get the bean from the spring container by using default Bean ID
		WrestlingCoach theCoach = context.getBean("wrestlingCoach",WrestlingCoach.class);
		
		// Call a method on the bean
		System.out.println(theCoach.getDailyWorkout());
		// Call method to get the daily fortune
		System.out.println(theCoach.getDailyFortune());
		
	
		
		// Close the container
		context.close();
	}

}
