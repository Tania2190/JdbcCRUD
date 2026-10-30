package com.resurrect.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.time.LocalDateTime;
import java.util.Scanner;

import com.resurrect.dto.Trainee;
import com.resurrect.service.ITraineeService;
import com.resurrect.servicefactory.TraineeServiceFactory;

public class Commence {
	static Scanner scanner = new Scanner(System.in);

	private static void insertOperation() {

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
		
	}

	private static void selectOperation() {
		
		System.out.print("Enter the trainee id :: ");
		int tid = scanner.nextInt();

		ITraineeService trnService = TraineeServiceFactory.getTraineeServiceObject();
		Trainee trainee = trnService.searchTrainee(tid);
		if (trainee != null) {
			System.out.println("ID \tNAME\tE-mail\t\tCOURSE_ENROLLED\tENROLLMENT_DATE");
			System.out.println(trainee.getTid() + "\t" + trainee.getTname() + "\t" + trainee.getTemail() + "\t"
					+ trainee.getTcourse() + "\t" + trainee.getEnrollmentDate());
		} else {
			System.out.println("Record not found for the given id :: " + tid);
		}
		
	}
	
	private static void updateOperation() {
		
	}
	
	private static void deleteOperation() {
		
		System.out.print("Enter the trainee id :: ");
		int tid = scanner.nextInt();
		
		ITraineeService trnService = TraineeServiceFactory.getTraineeServiceObject();
		String deleteMsg = trnService.deleteTrainee(tid);
		
		if (deleteMsg.equalsIgnoreCase("success")) {
			System.out.println("record deleted succesfully");
		} else if (deleteMsg.equalsIgnoreCase("not found")) {
			System.out.println("record not avilable for the given id ::" + tid);
		} else {
			System.out.println("record deletion failed");
		}
		
	}

	public static void main(String[] args) throws Exception {
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		while (true) {
			System.out.println("1. REGISTER");
			System.out.println("2. VIEW");
			System.out.println("3. UPDATE");
			System.out.println("4. DELETE");
			System.out.println("5. EXIT");
			System.out.print("ENTER AN OPTION, PRESS[1/2/3/4/5]::  ");
			String option = reader.readLine();
			
			switch (option) {
			case "1":
				insertOperation();
				break;
			case "2":
				selectOperation();
				break;
			case "3":
				updateOperation();
				break;
			case "4":
				deleteOperation();
				break;
			case "5":
				System.out.println("\n******* Thanks for using the application *****");
				System.exit(0);
			default:
				System.out.println("\n----Invalid option. Please try again----\n");
				break;
			}
		}

	}
}
