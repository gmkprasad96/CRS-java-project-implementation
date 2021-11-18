package com.lti.bean;

import java.util.List;

public class Student {
 
	private int studentId;
	private String branch;
	private int batch;
	private List<Course> primarySelectedCourses;
	private List<Course> alternativeSelectedCourses;
	
	/**
	 * @return the srollNo
	 */
	/**
	 * @return the primarySelectedCourses
	 */
	public List<Course> getPrimarySelectedCourses() {
		return primarySelectedCourses;
	}
	/**
	 * @param primarySelectedCourses the primarySelectedCourses to set
	 */
	public void setPrimarySelectedCourses(List<Course> primarySelectedCourses) {
		this.primarySelectedCourses = primarySelectedCourses;
	}
	/**
	 * @return the alternativeSelectedCourses
	 */
	public List<Course> getAlternativeSelectedCourses() {
		return alternativeSelectedCourses;
	}
	/**
	 * @param alternativeSelectedCourses the alternativeSelectedCourses to set
	 */
	public void setAlternativeSelectedCourses(
			List<Course> alternativeSelectedCourses) {
		this.alternativeSelectedCourses = alternativeSelectedCourses;
	}
	/**
	 * @return the report
	 */
	/**
	 * @return the studentId
	 */
	public int getStudentId() {
		return studentId;
	}
	/**
	 * @param studentId the studentId to set
	 */
	public void setStudentId(int studentId) {
		this.studentId = studentId;
	}
	/**
	 * @return the branch
	 */
	public String getBranch() {
		return branch;
	}
	/**
	 * @param branch the branch to set
	 */
	public void setBranch(String branch) {
		this.branch = branch;
	}
	/**
	 * @return the batch
	 */
	public int getBatch() {
		return batch;
	}
	/**
	 * @param batch the batch to set
	 */
	public void setBatch(int batch) {
		this.batch = batch;
	}
}
