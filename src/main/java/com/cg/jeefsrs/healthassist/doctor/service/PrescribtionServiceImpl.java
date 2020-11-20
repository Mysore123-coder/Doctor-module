package com.cg.jeefsrs.healthassist.doctor.service;

import com.cg.jeefsrs.healthassist.doctor.entity.PrescribtionEntity;
import com.cg.jeefsrs.healthassist.doctor.repository.PrescribtionDaoImpl;

public class PrescribtionServiceImpl implements PrescribtionService{

	PrescribtionDaoImpl prescribtiondirectory = new PrescribtionDaoImpl();
	public void addPrescribtion(PrescribtionEntity pres)
	{
//		doctorrepository.addPatientMedicalHistory(medicalHistory);
		prescribtiondirectory.addPrescribtion(pres);
	}

}
