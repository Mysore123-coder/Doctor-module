package com.cg.jeefsrs.healthassist.doctor.entity;

import java.io.Serializable;
import java.time.LocalDateTime;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

@Entity
@NamedQuery(name = "viewAllReports", query ="SELECT c FROM MedicalHistory c WHERE c.patientId = :pId")
@Table(name = "MEDICALHISTORY")
public class MedicalHistory implements Serializable{	
	private static final long serialVersionUID = 1L;
	@Id
	//@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column
	private int medicalRecordId;
	@Column(name = "PATIENTId")
	private int patientId;
	@Column
	private String patientName;
	@Column
	private String diagnosis;
	@Column
	private String treatment;
	@Column
	private String doctorName;
	@Column
	private LocalDateTime treatmentdate;	
	public int getMedicalRecordId() {
		return medicalRecordId;
	}
	public void setMedicalRecordId(int medicalRecordId) {
		this.medicalRecordId = medicalRecordId;
	}
	public int getPatientId() {
		return patientId;
	}
	public void setPatientId(int patientId) {
		this.patientId = patientId;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDiagnosis() {
		return diagnosis;
	}
	public void setDiagnosis(String diagnosis) {
		this.diagnosis = diagnosis;
	}
	public String getTreatment() {
		return treatment;
	}
	public void setTreatment(String treatment) {
		this.treatment = treatment;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}

	public MedicalHistory(int medicalRecordId, int patientId, String patientName, String diagnosis, String treatment,
			String doctorName, LocalDateTime treatmentdate) {
		super();
		this.medicalRecordId = medicalRecordId;
		this.patientId = patientId;
		this.patientName = patientName;
		this.diagnosis = diagnosis;
		this.treatment = treatment;
		this.doctorName = doctorName;
		this.treatmentdate = treatmentdate;
	}
	public MedicalHistory(){		
	}
	@Override
	public String toString() {
		return "MedicalHistory [medicalRecordId=" + medicalRecordId + ", patientId=" + patientId + ", patientName="
				+ patientName + ", diagnosis=" + diagnosis + ", treatment=" + treatment + ", doctorName=" + doctorName
				+ ", treatmentdate=" + treatmentdate + "]";
	}

}
