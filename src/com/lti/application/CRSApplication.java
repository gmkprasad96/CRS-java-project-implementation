package com.lti.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.lti.bean.User;
import com.lti.exception.UserNotFoundException;
import com.lti.service.UserInterface;
import com.lti.service.UserOperations;

public class CRSApplication {

	/**
	 * @param args
	 */
	static int selectedOption;
	static boolean isNotExit = true;
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub

		System.out.println("====Welcome to Course Registration System===");
		mainMenu();
	}
	/////////////////////////////////////////////////////////////////////////////////
	public static void mainMenu(){
		Scanner s1 = new Scanner(System.in);
		
		do{
			int choice = 0;
			System.out.println("Please select from below operations");
		
			System.out.println("  1. Login");
			System.out.println("  2. Student Registration");
			System.out.println("  3. Update Password");
			System.out.println("  4. Exit");
			System.out.println("Enter your choice :: ");
			s1 = new Scanner(System.in);
			
			try{
				choice = s1.nextInt();
			}catch(InputMismatchException ex){
				System.out.println("\n Please select options from above given menu \n");
			}
			
			if(choice == 1){
				loginOperation();
				isNotExit = false;
			}else if(choice == 2){
			
			}else if(choice == 3){
			
			}else if(choice == 4){
				System.out.println("========Thank you========");
				isNotExit = false;
			}else{
				System.out.print(" Please select in between 1 - 4 \n");
			}
		}while(isNotExit);
		s1.close();
	}
	////////////////////////////////////////////////////////////////////////
	@SuppressWarnings("resource")
	public static void loginOperation(){
	
		System.out.println("Please Login to start");
		
		System.out.println("Please select Role");
		
		List<String> roles = new ArrayList<>(Arrays.asList("Admin","Student","Professor"));
		
		for(String role : roles){
			System.out.println(" "+role);
		}
		
		Scanner s2 = new Scanner(System.in);
		String role = s2.nextLine();
		String userName = null, password = null;
		
		
		if(Pattern.matches("[a-zA-Z]+", role) == false){
			System.out.println("\n Please select options from above given menu \n");
			loginOperation();
		}else{
			
			System.out.println("Enter Username");
		    userName = s2.next();
			
			System.out.println("Enter Password");
			password = s2.next();
		
		
		UserInterface user = new UserOperations();
		
		User login = new User();
		login.setUserName(userName);
		login.setPassword(password);
		login.setRole(role);
		
		boolean isLogin = false;
		
		try {
			isLogin = user.doLogin(login);
		} catch (UserNotFoundException e) {
			System.out.println("------Invalid credentials-----\n"+e.getMessage()+"\n");
			loginOperation();
		}
		
		if(isLogin){
			
				switch(role){ 
				
					case "Admin":  //Admin Menu
	
					AdminMenu.showAdminMenu();
					break; 
					
					case "Student":   //Student Menu 
	
					StudentMenu.showStudentMenu();	
					break;  
					
					case "Professor":  //Professor Menu  
						
					ProfessorMenu.showProfessorMenu();	
					break;
					
					default:     
					System.out.println("Please select appropriate user"); 
				} 
				
			}else{
				try {
					throw new UserNotFoundException(userName);
				} catch (UserNotFoundException e) {
					System.out.println("------Invalid credentials-----\n"+e.getMessage()+"\n");
					loginOperation();
				}
			}
			s2.close();
		}
	}
	
}
