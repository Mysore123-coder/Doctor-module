package com.cg.jeefsrs.healthassist.doctor.service;
import java.util.List;

import com.cg.jeefsrs.healthassist.doctor.entity.MedicalHistory;
import com.cg.jeefsrs.healthassist.doctor.exception.PatientNotFoundException;
import com.cg.jeefsrs.healthassist.doctor.repository.DoctorDaoImpl;

public class DoctorServiceImpl implements DoctorService {
	DoctorDaoImpl doctorrepository=new DoctorDaoImpl();
	/** This method is to call the method in the DAO layer in this service layer for adding new patient medical history*/
	public void addPatientMedicalHistory(MedicalHistory medicalHistory) {
		doctorrepository.addPatientMedicalHistory(medicalHistory);
	}
	/** This method is to call the method in the DAO layer in this service layer for viewing the medical history of the patient 
	 * @throws PatientNotFoundException **/
	public MedicalHistory viewPatientMedicalRecord(int medicalRecordId) throws PatientNotFoundException {
		return doctorrepository.viewPatientMedicalRecord(medicalRecordId);
	}
	/** This method is to call the method in the DAO layer in this service layer for viewing the medical all the history of the patient **/
	public List<MedicalHistory> viewPatientMedicalHistory(int patientId)  throws PatientNotFoundException {
		
		return doctorrepository.viewPatientMedicalHistory(patientId);
	}
}
