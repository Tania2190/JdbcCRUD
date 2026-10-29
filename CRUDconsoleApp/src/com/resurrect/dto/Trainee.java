package com.resurrect.dto;

import java.io.Serializable;
import java.time.LocalDateTime;

public class Trainee implements Serializable{
	
	private static final long serialVersionUID = 1L;
	
	private Integer tid;
	private String tname;
	private String temail;
	private String tcourse;
	private LocalDateTime enrollmentDate;
	
	public Integer getTid() {
		return tid;
	}
	public void setTid(Integer tid) {
		this.tid = tid;
	}
	public String getTname() {
		return tname;
	}
	public void setTname(String tname) {
		this.tname = tname;
	}
	public String getTemail() {
		return temail;
	}
	public void setTemail(String temail) {
		this.temail = temail;
	}
	public String getTcourse() {
		return tcourse;
	}
	public void setTcourse(String tcourse) {
		this.tcourse = tcourse;
	}
	public LocalDateTime getEnrollmentDate() {
		return enrollmentDate;
	}
	public void setEnrollmentDate(LocalDateTime enrollmentDate) {
		this.enrollmentDate = enrollmentDate;
	}
	
	@Override
	public String toString() {
		return "Trainee [tid=" + tid + ", tname=" + tname + ", temail=" + temail + ", tcourse=" + tcourse
				+ ", enrollmentDate=" + enrollmentDate + "]";
	} 
	
	
	
}
