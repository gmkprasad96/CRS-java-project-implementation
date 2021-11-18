/**
 * 
 */
package com.lti.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lti.service.ProfessorInterface;
import com.lti.service.ProfessorOperations;

/**
 * @author user250
 *
 */
public class ProfessorMenu {

public static void showProfessorMenu(){
		
		System.out.println("===Welcome to Professor Portal===");
		System.out.println("Please select from below operations");
		System.out.println("  1.View Enrolled Students");
		System.out.println("  2.View Courses");
		System.out.println("  3.Add Student Grade");	
			
		
		Scanner sc = new Scanner(System.in);
		int selectedOption = 0;
		doProfessorOperations(selectedOption);
		
		try{
			selectedOption = sc.nextInt();
		}catch(InputMismatchException ex){
			System.out.println("\n Please select options from above given menu \n");
		}
		sc.close();
	}

	public static void doProfessorOperations(int selectedOption){
		
		ProfessorInterface professor = new ProfessorOperations();
		
		switch(selectedOption){
		case 1: 
			professor.viewEnrolledStudents();
			break; 
			
		case 2: 
			professor.addStudentGradeInReport(null,null);
			break;
			 
		case 3: 
			professor.viewCourses();
			break;
			
		default:     
		   System.out.println("Please select appropriate operation"); 
		}  
		
	}
}
