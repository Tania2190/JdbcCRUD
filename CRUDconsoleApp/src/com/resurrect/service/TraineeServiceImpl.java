package com.resurrect.service;

import java.time.LocalDateTime;

import com.resurrect.daofactory.TraineeDaoFactory;
import com.resurrect.dto.Trainee;
import com.resurrect.persistence.ITraineeDao;

public class TraineeServiceImpl implements ITraineeService {
	
	private ITraineeDao trnDao;

	@Override
	public String addTrainee(String tname, String temail, String course, LocalDateTime enrollmentDate) {
		trnDao = TraineeDaoFactory.getTraineeDaoObject();
		return trnDao.addTrainee(tname, temail, course, enrollmentDate);
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
