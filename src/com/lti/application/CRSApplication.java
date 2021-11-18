package com.lti.application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.InputMismatchException;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

import com.lti.bean.Course;
import com.lti.bean.User;
import com.lti.bean.GradeCard;
import com.lti.bean.Student;
import com.lti.exception.UserNotFoundException;
import com.lti.service.AdminInterface;
import com.lti.service.AdminOperations;
import com.lti.service.ProfessorInterface;
import com.lti.service.ProfessorOperations;
import com.lti.service.StudentInterface;
import com.lti.service.StudentOperations;
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
		Scanner s1 = null;
		
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
			Scanner s3 = null;	
			
				switch(role){ 
				
				case "Admin": 
				System.out.println("===Welcome to Admin Portal===");
				System.out.println("Please select from below operations");
				System.out.println("  1.Add Course");
				System.out.println("  2.Remove Course");
				System.out.println("  3.Add Professor");
				System.out.println("  4.Generate Report Card");
				System.out.println("  5.Approve Student Registration");	
				
				s3 = new Scanner(System.in);
				
				try{
					selectedOption = s3.nextInt();
					}catch(InputMismatchException ex){
						System.out.println("\n Please select options from above given menu \n");
					}
				
				doOperations(role, selectedOption);
				break; 
				
				case "Student":    
				System.out.println("===Welcome to Student Portal===");
				System.out.println("Please select from below operations");
				System.out.println("  1.Register for the Course");
				System.out.println("  2.Add Course");
				System.out.println("  3.Drop Course");
				System.out.println("  4.View Grade");
				System.out.println("  5.Pay Fee");	
				
				s3 = new Scanner(System.in);
				try{
					selectedOption = s3.nextInt();
					}catch(InputMismatchException ex){
						System.out.println("\n Please select options from above given menu \n");
					}
				doOperations(role, selectedOption);
				break;  
				
				case "Professor":    
				System.out.println("===Welcome to Professor Portal===");
				System.out.println("Please select from below operations");
				System.out.println("  1.View Enrolled Students");
				System.out.println("  2.View Courses");
				System.out.println("  3.Add Student Grade");	
				
				s3 = new Scanner(System.in);
				try{
					selectedOption = s3.nextInt();
					}catch(InputMismatchException ex){
						System.out.println("\n Please select options from above given menu \n");
					}
				doOperations(role, selectedOption);
				
				default:     
				System.out.println("Please select appropriate user"); 
				} 
				s3.close();
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
	
	/////////////////////////////////////////////////////////////////////////////////
	
	public static void doOperations(String role, int selectedOption){
		
		if(role.equals("Admin")){
			
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
			
		}else if(role.equals("Student")){
			
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
		}else if(role.equals("Professor")){
			
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
		}else{
			System.out.println("Please select appropriate user");
		}	
	}
	
	
}
