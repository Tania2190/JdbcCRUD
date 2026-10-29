package com.resurrect.service;

import java.time.LocalDateTime;

import com.resurrect.dto.Trainee;
import com.resurrect.persistence.ITraineeDao;

public class TraineeServiceImpl implements ITraineeService {
	
	private ITraineeDao trnDao;

	@Override
	public String addTrainee(String tname, String temail, String course, LocalDateTime enrollmentDate) {
		return null;
	}

	@Override
	public Trainee searchTrainee(Integer tid) {
		return null;
	}

	@Override
	public String updateTrainee(Trainee trainee) {
		return null;
	}

	@Override
	public String deleteTrainee(Integer tid) {
		return null;
	}

}
