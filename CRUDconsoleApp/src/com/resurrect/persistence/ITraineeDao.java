package com.resurrect.persistence;

import java.time.LocalDateTime;

import com.resurrect.dto.Trainee;

public interface ITraineeDao {
	
	//operations
	public String addTrainee(String tname, String temail, String course, LocalDateTime enrollmentDate);
	
	public Trainee searchTrainee(Integer tid);
	
	public String updateTrainee(Trainee trainee);
	
	public String deleteTrainee(Integer tid);

}
