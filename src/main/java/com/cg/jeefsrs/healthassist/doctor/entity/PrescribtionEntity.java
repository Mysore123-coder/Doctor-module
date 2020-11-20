package com.cg.jeefsrs.healthassist.doctor.entity;

import java.io.Serializable;

import javax.persistence.*;
@Entity

@Table(name="prescribtion")
public class PrescribtionEntity implements Serializable{
	
	private static final long serialVersionUID = 1L;
	@Id
	@Column(name="prescribitonId",unique=true)
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int prescribitonId;

	@Column(name="patientName", nullable = false)
	private String patientName;

	@Column(name="patient_id", nullable = false)
	private int patient_id;

	@Column(name="doctor_id", nullable = false)
	private int doctor_id;

	@Column(name="description", nullable = false)
	private String description;

	@Column(name="quantity_of_med", nullable = false)
	private int quantityOfMed;
	
	@Column(name="numDays", nullable = false)
	private int numDays;

	public PrescribtionEntity(int doctorId, int patientId, String patientName2, String desp, int quantity,
			int days) {
		super();
		this.doctor_id = doctorId;
		this.patient_id = patientId;
		this.description = desp;
		this.patientName = patientName2;
		this.quantityOfMed = quantity;
		this.numDays = days;
	}
	public PrescribtionEntity()
	{
		
	}
	public int getQuantityOfMed() {
		return quantityOfMed;
	}

	public String getPatientName() {
		return patientName;
	}

	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}

	public void setQuantityOfMed(int quantityOfMed) {
		this.quantityOfMed = quantityOfMed;
	}

	public int getNumDays() {
		return numDays;
	}

	public void setNumDays(int numDays) {
		this.numDays = numDays;
	}

	public int getPrescribitonId() {
		return prescribitonId;
	}

	public void setPrescribitonId(int prescribitonId) {
		this.prescribitonId = prescribitonId;
	}


	public int getPatient_id() {
		return patient_id;
	}

	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}

	public int getDoctor_id() {
		return doctor_id;
	}

	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}
}