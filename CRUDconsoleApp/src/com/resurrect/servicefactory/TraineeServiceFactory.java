package com.resurrect.servicefactory;

import com.resurrect.service.ITraineeService;
import com.resurrect.service.TraineeServiceImpl;

public class TraineeServiceFactory {
	
	private TraineeServiceFactory() {}
	
	private static ITraineeService traineeService = null;
	
	public static ITraineeService getTraineeServiceObject() {
		if(traineeService == null) {
			traineeService = new TraineeServiceImpl();
		}
		return traineeService;
	}

}
