package com.cg.jeefsrs.healthassist.doctor.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;

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
public class DoctorServiceImplTest {
	DoctorService doctor;
	EntityManager entityManager;
	/** setUp() method to setUp value before each test */
	@BeforeEach
	void setUp() throws Exception {
		doctor = new DoctorServiceImpl();
		entityManager = JPaUtil.getEntityManager();
	}
	@AfterEach
	void tearDown() throws Exception { 
		doctor=null;
		entityManager.close();
	}	
	@Test
	void testDoctorServiceImpl() {
		doctor=new DoctorServiceImpl();
		assertTrue(doctor instanceof DoctorServiceImpl);
	}
	/** To test the ViewPatientMedicalHistory method in service layer using JUNIT test */
	@Test	
	void testAddPatientMedicalHistory()  {
		MedicalHistory medHistory = new MedicalHistory(15,12,"aaa","xxx","sss","KKk",LocalDateTime.now());
        entityManager.persist(medHistory);
        String patientName="aaa";
        String patientDiagnosis="xxx";
        int patientId=15;
        doctor.addPatientMedicalHistory(medHistory);
		assertEquals(medHistory.getPatientName(),patientName);
		assertEquals(medHistory.getDiagnosis(),patientDiagnosis);
		assertNotEquals(medHistory.getPatientId(),patientId);
	}
	@Test	
	/** To test the addNewMedicalHistory method in service layer using JUNIT test **/
	void testViewPatientMedicalRecord()throws PatientNotFoundException  {
		//	MedicalHistory medHistory = new MedicalHistory(15,12,"aaa","xxx","sss","KKk",LocalDateTime.now());
		doctor.viewPatientMedicalRecord(12);
        MedicalHistory medicalHistoryFound = entityManager.find(MedicalHistory.class,12);
        MedicalHistory medicalHistoryNotFound = entityManager.find(MedicalHistory.class,6);
        assertNotNull(medicalHistoryFound);
		assertNull(medicalHistoryNotFound);
		
		//fail("Not yet implemented");
	}	
}
