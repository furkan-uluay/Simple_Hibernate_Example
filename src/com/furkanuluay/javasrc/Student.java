package com.furkanuluay.javasrc;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;


@Entity(name="STUDENT")
public class Student {
	
	
	@Id @GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="STUDENT_ID")
	private int stdId;
	
	@Column(name="STUDENT_NAME")
	private String stdName;
	
	@Column(name="STUDENT_SURNAME")
	private String stdSurname;
	
	
	public int getStdId() {
		return stdId;
	}
	public void setStdId(int stdId) {
		this.stdId = stdId;
	}
	public String getStdName() {
		return stdName;
	}
	public void setStdName(String stdName) {
		this.stdName = stdName;
	}
	public String getStdSurname() {
		return stdSurname;
	}
	public void setStdSurname(String stdSurname) {
		this.stdSurname = stdSurname;
	}
	
	
	
	
	
	
	

	
	
	
}
