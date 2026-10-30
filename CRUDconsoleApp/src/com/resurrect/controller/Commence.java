package com.resurrect.controller;

import java.io.BufferedReader;
import java.io.IOException;
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

		System.out.print("\nEnter your name :: ");
		String name = scanner.next();

		System.out.print("Enter the email :: ");
		String mail = scanner.next();

		System.out.print("Enter the course enrolled :: ");
		String course = scanner.next();

		LocalDateTime enrollmentDate = LocalDateTime.now();
		System.out.print("Your enrollment date :: " + enrollmentDate + "\n\n");

		String msg = trnService.addTrainee(name, mail, course, enrollmentDate);
		if (msg.equalsIgnoreCase("success")) {
			System.out.println("record inserted succesfully"+ "\n");
		} else {
			System.out.println("record insertion failed"+ "\n");
		}
		
	}

	private static void selectOperation() {
		
		System.out.print("Enter the trainee id :: ");
		int tid = scanner.nextInt();

		ITraineeService trnService = TraineeServiceFactory.getTraineeServiceObject();
		Trainee trainee = trnService.searchTrainee(tid);
		if (trainee != null) {
			System.out.println("\nID \tNAME\tE-mail\t\tCOURSE_ENROLLED\tENROLLMENT_DATE");
			System.out.println(trainee.getTid() + "\t" + trainee.getTname() + "\t" + trainee.getTemail() + "\t"
					+ trainee.getTcourse() + "\t" + trainee.getEnrollmentDate() + "\n");
		} else {
			System.out.println("Record not found for the given id :: " + tid);
		}
		
	}
	
	private static void updateOperation() throws IOException {
		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
		System.out.print("Enter your id :: ");
		String id = reader.readLine();
		
		ITraineeService trnService = TraineeServiceFactory.getTraineeServiceObject();
		Trainee trainee = trnService.searchTrainee(Integer.parseInt(id));
		
		if (trainee != null) {
			Trainee newTrainee = new Trainee();
			
			System.out.println("Trainee id is :: "+ trainee.getTid());
			newTrainee.setTid(trainee.getTid());
			
			System.out.print("Trainee Name :: " + trainee.getTname() + "\t" + "new Name :: " );
			String newName = reader.readLine();
			if(newName.equals("") || newName=="") {
				newTrainee.setTname(trainee.getTname());
			} else {
				newTrainee.setTname(newName);
			}
			
			System.out.print("Trainee Email :: " + trainee.getTemail() + "\t" + "new Email :: " );
			String newEmail = reader.readLine();
			if(newEmail.equals("") || newEmail=="") {
				newTrainee.setTemail(trainee.getTemail());
			} else {
				newTrainee.setTemail(newEmail);
			}
			
			System.out.print("Course Enrolled :: " + trainee.getTcourse() + "\t" + "new Course :: " );
			String newCourse = reader.readLine();
			if(newCourse.equals("") || newCourse=="") {
				newTrainee.setTcourse(trainee.getTcourse());
			} else {
				newTrainee.setTcourse(newCourse);
			}
			
			System.out.println("Enrollment Date :: " + trainee.getEnrollmentDate());
			newTrainee.setEnrollmentDate(trainee.getEnrollmentDate());
			
			System.out.println("\nUpdated trainee info : " + newTrainee + "\n");
			
			String status = trnService.updateTrainee(newTrainee);
			if (status.equalsIgnoreCase("success")) {
				System.out.println("record updated succesfully"+ "\n");
			} else {
				System.out.println("record updation failed");
			}
		} else {
			System.out.println("Trainee record not available for the given id  " + id + "\n");
		}
		
	}
	
	private static void deleteOperation() {
		
		System.out.print("Enter the trainee id :: ");
		int tid = scanner.nextInt();
		
		ITraineeService trnService = TraineeServiceFactory.getTraineeServiceObject();
		String deleteMsg = trnService.deleteTrainee(tid);
		
		if (deleteMsg.equalsIgnoreCase("success")) {
			System.out.println("\nrecord deleted succesfully");
		} else if (deleteMsg.equalsIgnoreCase("not found")) {
			System.out.println("\nrecord not avilable for the given id ::" + tid + "\n");
		} else {
			System.out.println("\nrecord deletion failed");
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
