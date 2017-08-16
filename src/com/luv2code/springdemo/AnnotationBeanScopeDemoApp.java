package com.luv2code.springdemo;

import org.springframework.context.support.ClassPathXmlApplicationContext;

public class AnnotationBeanScopeDemoApp {

	public static void main(String[] args) {
		
		// Load Spring Config file
		ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("applicationContext.xml");
		
		// Retrieve bean from Spring container
		Coach theCoach = context.getBean("tennisCoach",Coach.class);
		Coach alphaCoach =context.getBean("tennisCoach",Coach.class);
		
		// Check if the beans are the same
		boolean result = (theCoach == alphaCoach);
		
		// Print out the results
		System.out.println("\n Pointing to the same object " + result);
		System.out.println(" \n Memory location for theCoach " + theCoach);
		System.out.println(" \n Memory location for alphaCoach " + alphaCoach + "\n");
		
		// Close the context
		context.close();

	}

}
