/**
 * 
 */
package com.lti.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

import com.lti.bean.Course;
import com.lti.bean.Professor;
import com.lti.bean.GradeCard;
import com.lti.bean.Student;

/**
 * @author user252
 *
 */
public class ProfessorOperations implements ProfessorInterface{
	
	public void viewEnrolledStudents(){
		
		List<Student> students = new ArrayList<>();
		
		 for (Student s : students) {
	
	       	    System.out.println("Roll No "+s.getStudentId()+" "+"Branch "+s.getBranch()+" "+"Batch "+s.getBatch());
	       	    
	       	    System.out.println("Slected Primary Courses");
	       	    for(Course c : s.getPrimarySelectedCourses()){
	       	      System.out.print(c.getCourseCode()+" "+c.getName()+" "+c.getInstructor());
	       	    }
	       	   System.out.println("Selected Alternate Courses");
	       	    for(Course ac : s.getAlternativeSelectedCourses()){
	       	     System.out.print(ac.getCourseCode()+" "+ac.getName()+" "+ac.getInstructor());
	       	    }
	       	}
	}
	
	public void viewCourses(){
		List<Course> courses = new ArrayList<>();
		System.out.println("Professor Courses");
   	    for(Course c : courses){
   	     System.out.print(c.getCourseCode()+" "+c.getName()+" "+c.getInstructor());   	    }
	}
	
	public void addStudentGradeInReport(Student s, GradeCard c){

	    System.out.println("Student Report updated");	
	}
}
