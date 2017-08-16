package com.luv2code.springdemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

import javax.annotation.PostConstruct;

import java.util.List;

import org.springframework.stereotype.Component;

@Component
public class FileFortuneService implements FortuneService {

	private List<String> data; 
	private String file = "C:\\Users\\miche\\eclipse-workspace\\spring-demo-annotations\\src\\fortune-data.txt";
	private Random myRandom = new Random();

	public FileFortuneService() {
		System.out.println(">> FileFortuneService: inside default constructor");
	}

	@PostConstruct
	private void loadTheFortuneFile() {
		System.out.println(">> FileFortuneService: inside method loadTheFortunesFile");

		File theFile = new File(file);
		System.out.println("Reading fortunes from file: " + theFile);
		System.out.println("File exists: " + theFile.exists());
		
		data =new ArrayList<String>();
		
		// read fortunes from file
				try (BufferedReader br = new BufferedReader(
						new FileReader(theFile))) {

					String tempLine;

					while ((tempLine = br.readLine()) != null) {
						data.add(tempLine);
					}
					
				} catch (IOException e) {
					e.printStackTrace();
				}
	} 

	@Override
	public String getFortune() {
		int index = myRandom.nextInt(data.size());
		String theFortune = data.get(index);
		return theFortune;
	}

}
