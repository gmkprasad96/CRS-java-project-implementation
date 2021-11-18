/**
 * 
 */
package com.lti.service;

import com.lti.bean.Course;
import com.lti.bean.GradeCard;
import com.lti.bean.Student;

/**
 * @author user252
 *
 */
public class StudentOperations implements StudentInterface{
	
	Student s = new Student();
	Course c = new Course();
	GradeCard r = new GradeCard();
	
	public void registerForCourse(){}
	
	public void addCourses(){}
	
	public void dropCourses(){}
	
	public void viewGrades(){}

	/* (non-Javadoc)
	 * @see com.lti.service.StudentInterface#payFees()
	 */
	@Override
	public void payFees() {
		// TODO Auto-generated method stub
		
	}
	
}
