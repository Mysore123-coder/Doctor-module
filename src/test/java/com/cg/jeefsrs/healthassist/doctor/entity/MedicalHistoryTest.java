package com.cg.jeefsrs.healthassist.doctor.entity;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class MedicalHistoryTest {
	MedicalHistory med;
	@BeforeEach
	void setUp() throws Exception {
		med =new MedicalHistory();
	}
	@AfterEach
	void tearDown() throws Exception {
		med=null;
	}
	@Test
	void testMedicalRecordId() {
	med.setMedicalRecordId(1);
	assertEquals(med.getMedicalRecordId(),1);
	assertNotEquals(med.getMedicalRecordId(),5);
	}
	@Test
	void testPatientId() {
	med.setPatientId(1);
	assertEquals(med.getPatientId(),1);
	assertNotEquals(med.getPatientId(),5);
	}
	@Test
	void testPatientName() {
	med.setPatientName("Mani");
	assertEquals(med.getPatientName(),"Mani");
	assertNotEquals(med.getPatientName(),"Mozhi");
	}
	@Test
	void testDiagnosis() {
	med.setDiagnosis("Fever");
	assertEquals(med.getDiagnosis(),"Fever");
	assertNotEquals(med.getDiagnosis(),"cough");
	}
	@Test
	void testTreatment() {
	med.setTreatment("xxx");
	assertEquals(med.getTreatment(),"xxx");
	assertNotEquals(med.getTreatment(),"zzz");
	}
	@Test
	void testDoctorName() {
	med.setDoctorName("Mani");
	assertEquals(med.getDoctorName(),"Mani");
	assertNotEquals(med.getDoctorName(),"Mozhi");
	}
	@Test
	void testMedicalHistory() {
		med=new MedicalHistory();
		assertTrue(med instanceof MedicalHistory);
	}
}
