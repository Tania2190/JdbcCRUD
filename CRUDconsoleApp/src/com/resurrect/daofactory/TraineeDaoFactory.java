package com.resurrect.daofactory;

import com.resurrect.persistence.ITraineeDao;
import com.resurrect.persistence.TraineeDaoImpl;

public class TraineeDaoFactory {
	
	private TraineeDaoFactory() {}
	
	private static ITraineeDao traineeDao = null;
	
	public static ITraineeDao getTraineeDaoObject() {
		
		if(traineeDao == null) {
			traineeDao = new TraineeDaoImpl();
		}
		return traineeDao;
		
	}

}
