package com.cg.jeefsrs.healthassist.doctor.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

//import org.junit.Before;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.cg.jeefsrs.healthassist.doctor.entity.MedicalHistory;
import com.cg.jeefsrs.healthassist.doctor.exception.PatientNotFoundException;
import com.cg.jeefsrs.healthassist.doctor.util.JPaUtil;
/** Class to test the methods in DoctorDaoImplclass 
 * 
 * @author Sandhya and Amrutha
 *
 */
public class DoctorDaoImplTest {
	DoctorDao doctor;
	EntityManager entityManager;
	/** setUp() method to setUp value before each test */
	@BeforeEach
	void setUp() throws Exception {		
		doctor = new DoctorDaoImpl();
		entityManager = JPaUtil.getEntityManager();
   }
	/** TearDown() method to setUp value before each test */
	@AfterEach
	void tearDown() throws Exception {      
		doctor=null;
		entityManager.close();		 
	}	
	@Test
	void testDoctorDao() {
		doctor=new DoctorDaoImpl();
		assertTrue(doctor instanceof DoctorDaoImpl);
	}	
	@Test
	/** To test the ViewPatientMedicalHistory method using JUNIT test in Dao layer */
	void testViewPatientMedicalRecord() throws PatientNotFoundException {
		
        doctor.viewPatientMedicalRecord(12);
        MedicalHistory medicalHistoryFound = entityManager.find(MedicalHistory.class,12);
        MedicalHistory medicalHistoryNotFound = entityManager.find(MedicalHistory.class,6);
        assertNotNull(medicalHistoryFound);
		assertNull(medicalHistoryNotFound);	
	}
	@Test   
	/** To test the addNewMedicalHistory method in the Dao layer using JUNIT test **/
	void testaddPatientMedicalHistory() {
		MedicalHistory medHistory = new MedicalHistory(15,12,"aaa","xxx","sss","KKk",LocalDateTime.now());
        entityManager.persist(medHistory);
        String patientName="aaa";
        String patientDiagnosis="xxx"; 
        doctor.addPatientMedicalHistory(medHistory);
		assertEquals(medHistory.getPatientName(),patientName);
		assertEquals(medHistory.getDiagnosis(),patientDiagnosis);
	}
}
