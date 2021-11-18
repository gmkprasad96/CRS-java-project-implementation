/**
 * 
 */
package com.lti.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lti.service.StudentInterface;
import com.lti.service.StudentOperations;

/**
 * @author user250
 *
 */
public class StudentMenu {

public static void showStudentMenu(){
		
		System.out.println("===Welcome to Student Portal===");
		System.out.println("Please select from below operations");
		System.out.println("  1.Register for the Course");
		System.out.println("  2.Add Course");
		System.out.println("  3.Drop Course");
		System.out.println("  4.View Grade");
		System.out.println("  5.Pay Fee");	
		
		Scanner sc = new Scanner(System.in);
		int selectedOption = 0;
		try{
			selectedOption = sc.nextInt();
		}catch(InputMismatchException ex){
				System.out.println("\n Please select options from above given menu \n");
		}
		doStudentOperations(selectedOption);
		sc.close();
	}
	
public static void doStudentOperations(int selectedOption){
		
	StudentInterface student = new StudentOperations();
	
	switch(selectedOption){
	case 1: 
		student.registerForCourse();
		break; 
		
	case 2: 
		student.addCourses();
		break;
		 
	case 3: 
		student.dropCourses();
		break;
		
	case 4: 
		student.viewGrades();
		break;
		
	case 5: 
		student.payFees();
		break;
	default:     
	   System.out.println("Please select appropriate operation"); 
	}  
	}

}
