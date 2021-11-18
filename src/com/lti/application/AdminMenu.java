/**
 * 
 */
package com.lti.application;

import java.util.InputMismatchException;
import java.util.Scanner;

import com.lti.service.AdminInterface;
import com.lti.service.AdminOperations;

/**
 * @author user250
 *
 */
public class AdminMenu {

	public static void showAdminMenu(){
		
		System.out.println("===Welcome to Admin Portal===");
		System.out.println("Please select from below operations");
		System.out.println("  1.Add Course");
		System.out.println("  2.Remove Course");
		System.out.println("  3.Add Professor");
		System.out.println("  4.Generate Report Card");
		System.out.println("  5.Approve Student Registration");	
		
		Scanner sc = new Scanner(System.in);
		int selectedOption = 0;
		doAdminOperations(selectedOption);
		
		try{
				selectedOption = sc.nextInt();
		}catch(InputMismatchException ex){
				System.out.println("\n Please select options from above given menu \n");
		}
		sc.close();
		
	}
	
	public static void doAdminOperations(int selectedOption){
		
		AdminInterface admin = new AdminOperations();
		
		switch(selectedOption){
		case 1: 
			admin.addCoursesInCatalogue();
			break; 
			
		case 2: 
			admin.removeCoursesFromCatalogue();
			break;
			 
		case 3: 
			admin.addProfessor();
			break;
			
		case 4: 
			admin.generateReportCard();
			break;
			
		case 5: 
			admin.approveStudentRegistration();
			break;
		default:     
		   System.out.println("Please select appropriate operation"); 
		} 
	}
}
