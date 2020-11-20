package com.cg.jeefsrs.healthassist.doctor.repository;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.persistence.TypedQuery;

import com.cg.jeefsrs.healthassist.doctor.entity.MedicalHistory;
import com.cg.jeefsrs.healthassist.doctor.exception.PatientNotFoundException;
import com.cg.jeefsrs.healthassist.doctor.util.JPaUtil;

public class DoctorDaoImpl implements DoctorDao {	
	/** This method is to execute the logic for viewing the patient medical history **/
	@Override
	public MedicalHistory viewPatientMedicalRecord(int medicalRecordId)throws PatientNotFoundException {		
		EntityManager em = JPaUtil.getEntityManager();
		MedicalHistory medicalHistory = em.find(MedicalHistory.class,medicalRecordId);		 
			try{
				if(medicalHistory == null){
					throw new PatientNotFoundException("Patient Not Found");
				}
			}
			catch(PatientNotFoundException e){
				e.getMessage();
			}
		return medicalHistory;
	}
	@Override
	@SuppressWarnings("unchecked")
	@PersistenceContext
	/** This method is to execute the logic for view the entire patient medical history **/
	public List<MedicalHistory> viewPatientMedicalHistory(int patientId)throws PatientNotFoundException{
		EntityManager em = JPaUtil.getEntityManager();
		TypedQuery<MedicalHistory> query= (TypedQuery<MedicalHistory>) em.createNamedQuery("viewAllReports").setParameter("pId", patientId);
		//Query query= em.createQuery("select m from medicalhistory m where patientid=?1");
		//TypedQuery<MedicalHistory> query = (TypedQuery<MedicalHistory>) em.createQuery("SELECT c FROM MedicalHistory c WHERE c.patientid = :patientid", MedicalHistory.class).setParameter("patientid", patientId).getResultList();
		//return query.setParameter("name", name).getSingleResult();
		try {
			if(query.getResultList().isEmpty())
				throw new PatientNotFoundException("Report list is empty");
		} catch (PatientNotFoundException e) {
			System.out.println(e.getMessage());
		}
		return  query.getResultList();
	}
	/** This method is to execute the logic for adding the patient medical history **/
	@Override
	public void addPatientMedicalHistory(MedicalHistory medicalHistory) {
		EntityManager em = JPaUtil.getEntityManager();  
		try {
			em.getTransaction().begin();  
			em.persist(medicalHistory);    
			em.getTransaction().commit(); 
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			e.getMessage();
		}
		em.close(); 
		System.out.println("Medical History added successfully");		
	}
}


