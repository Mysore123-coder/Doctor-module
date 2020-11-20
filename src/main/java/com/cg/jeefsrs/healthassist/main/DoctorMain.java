package com.cg.jeefsrs.healthassist.main;

import java.time.LocalDateTime;
import java.util.InputMismatchException;
import java.util.Scanner;

import com.cg.jeefsrs.healthassist.doctor.entity.MedicalHistory;
import com.cg.jeefsrs.healthassist.doctor.exception.PatientNotFoundException;
import com.cg.jeefsrs.healthassist.doctor.service.DoctorService;
import com.cg.jeefsrs.healthassist.doctor.service.DoctorServiceImpl;
import com.cg.jeefsrs.healthassist.doctor.service.PrescribtionService;
import com.cg.jeefsrs.healthassist.doctor.service.PrescribtionServiceImpl;
import com.cg.jeefsrs.healthassist.doctor.entity.PrescribtionEntity;


/** class to implement main method
 * 
 *  @author Sandhya and Amrutha	
 *
 */
public class DoctorMain {
	private static DoctorService doctorService;
	private static PrescribtionService prescribtionService;
	static Scanner sc = new Scanner(System.in);
	/**
	 * Initializing the objects for service layer
	 */
	static {
		doctorService = new DoctorServiceImpl();
		prescribtionService = new PrescribtionServiceImpl();
	} 
	@SuppressWarnings("resource")
	public static void main(String[] args) {
		int choice;
		do {
			System.out.println("Doctor Menu");
			System.out.println("1. Add Patient Medical History");
			System.out.println("2. View Patient Medical History");
			System.out.println("3. Add Prescribtion");
			System.out.println("4. Exit");			
			Scanner sc=new Scanner(System.in);
			System.out.println("enter your choice");
			choice=0;
			try {
				choice = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid option,please choose a valid option");
			}
			sc.nextLine();
			switch (choice) {
			case 1:
				try {
					addPatientOption();
				} catch (PatientNotFoundException e2) {
					e2.printStackTrace();
				}
				break;
			case 2:
				try {
					viewOneRecordOption();
				} catch (PatientNotFoundException e1) {
					e1.printStackTrace();
				}
				break;
			case 3:
				try {
					addPrescribtion();
				} catch (PatientNotFoundException e) {
					e.printStackTrace();
				}
				break;
			case 4:
				System.out.println("Thank you for using the application!");
				break;
			default:
				System.out.println("please select valid option");
				break;
			}
		} while (choice != 4);
	}	
	/** This method do the find patient */
	private static void viewOneRecordOption() throws PatientNotFoundException {
		int mid = 0;
		System.out.println("enter medicalRecordId to find patient");
		do {
			try {
				mid = sc.nextInt();
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please enter a number for Id");
			}
			sc.nextLine();
		} while (mid <= 0);
		System.out.println(doctorService.viewPatientMedicalRecord(mid));
	}
	/** This method do the add patient */
	private static void addPatientOption() throws PatientNotFoundException {
		int mid = 0;
		int pid = 0;
		System.out.println("enter patient details to be added (medicalrecordid, patientid, patientname,diagnosis,treatment,doctorname)");
		do {
			try {
				mid = sc.nextInt(); 
				pid = sc.nextInt();			
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please enter a valid input");
			}
			sc.nextLine();
		} while (mid <= 0 && pid <= 0);
		String pname = sc.next();
		String diag = sc.next();
		String treat = sc.next();
		String dname = sc.next();
		MedicalHistory medicalHistory=new MedicalHistory(mid,pid,pname,diag,treat,dname,LocalDateTime.now());
		doctorService.addPatientMedicalHistory(medicalHistory);
	}
	
	/** This method do the add prescription */
	private static void addPrescribtion() throws PatientNotFoundException {
		int doctorId = 0, patientId = 0;
		System.out.println("Enter Patient Id to find entire Medical Record of a Patient");
		do {
			try {
				System.out.println("Enter Doctor Id");
				doctorId = sc.nextInt();
				System.out.println("Enter Patient ID");
				patientId = sc.nextInt();		
			} catch (InputMismatchException e) {
				System.out.println("Invalid input, please enter a number for Id");
			}
			sc.nextLine();
		}  while (doctorId <= 0 && patientId <= 0);
		System.out.println("Enter Patient Name");
		String patientName = sc.nextLine();
		System.out.println("Enter Description");
		String desp = sc.nextLine();
		System.out.println("Enter Quatity");
		int quantity = sc.nextInt();
		System.out.println("Enter Num of Days");
		int days = sc.nextInt();
		System.out.println(doctorId);
		System.out.println(patientId);
		System.out.println(patientName);
		System.out.println(desp);
		System.out.println(quantity);
		System.out.println(days);
		
		PrescribtionEntity pres = new PrescribtionEntity(doctorId,patientId,patientName,desp,quantity,days);
		prescribtionService.addPrescribtion(pres);
}
}