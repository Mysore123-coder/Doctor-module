package com.cg.jeefsrs.healthassist.doctor.test;

import org.junit.runner.RunWith;

import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

import com.cg.jeefsrs.healthassist.doctor.entity.MedicalHistory;
import com.cg.jeefsrs.healthassist.doctor.service.*;
import com.cg.jeefsrs.healthassist.doctor.repository.*;
@RunWith(Suite.class)
@SuiteClasses({DoctorDaoImplTest.class,DoctorServiceImplTest.class,MedicalHistory.class})
public class AllTests {

}
