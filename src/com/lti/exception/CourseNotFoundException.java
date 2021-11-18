/**
 * 
 */
package com.lti.exception;

/**
 * @author user250
 *
 */
public class CourseNotFoundException extends Exception {
	
	private String courseCode;
	
	public CourseNotFoundException(String courseCode)
	{	
		this.courseCode = courseCode;
	}
	
	public String getMessage() 
	{
		return "Course with courseCode: " + courseCode + " not found";
	}
}
