package com.cg.jeefsrs.healthassist.doctor.repository;
import java.util.List;

import com.cg.jeefsrs.healthassist.doctor.entity.MedicalHistory;
import com.cg.jeefsrs.healthassist.doctor.exception.PatientNotFoundException;


public interface DoctorDao {
	 /** The viewPatientMedicalHistory method will return the medical history of the patient whose patient id is passed inside the method as an argument
	 * @throws PatientNotFoundException */
	 public MedicalHistory viewPatientMedicalRecord(int medicalRecordId) throws PatientNotFoundException;
	 /** The addNewMedicalHistory method will help us to add the medical history into the medical history table
	 * @throws PatientNotFoundException */
    public void addPatientMedicalHistory(MedicalHistory medicalHistory);
    /** The viewPatientMedicalHistory method will return the medical history of the patient whose patient id is passed inside the method as an argument
     * @throws PatientNotFoundException */
    public List<MedicalHistory> viewPatientMedicalHistory(int patientId) throws PatientNotFoundException;


}
