package com.resurrect.controller;

import java.time.LocalDateTime;
import java.util.Scanner;

import com.resurrect.dto.Trainee;
import com.resurrect.service.ITraineeService;
import com.resurrect.servicefactory.TraineeServiceFactory;

public class Commence {

	private static void insertOperation() {

		Scanner scanner = new Scanner(System.in);
		ITraineeService trnService;

		trnService = TraineeServiceFactory.getTraineeServiceObject();

		System.out.print("Enter your name :: ");
		String name = scanner.next();

		System.out.print("Enter the email :: ");
		String mail = scanner.next();

		System.out.print("Enter the course enrolled :: ");
		String course = scanner.next();

		LocalDateTime enrollmentDate = LocalDateTime.now();
		System.out.print("Your enrollment date :: " + enrollmentDate + "\n\n");

		String msg = trnService.addTrainee(name, mail, course, enrollmentDate);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully");
		} else {
			System.out.println("record insertion failed");
		}
		scanner.close();
	}

	private static void selectOperation() {
		
	}
	
	private static void updateOperation() {
		
	}
	
	private static void deleteOperation() {
		
	}

	public static void main(String[] args) {

		insertOperation();
		//selectOperation();
		//updateOperation();
		//deleteOperation();

	}

}
