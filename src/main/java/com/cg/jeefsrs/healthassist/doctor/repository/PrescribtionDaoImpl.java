package com.cg.jeefsrs.healthassist.doctor.repository;

import javax.persistence.EntityManager;

import com.cg.jeefsrs.healthassist.doctor.entity.PrescribtionEntity;
import com.cg.jeefsrs.healthassist.doctor.util.JPaUtil;

public class PrescribtionDaoImpl implements PrescribtionDao{
	@Override
	public void addPrescribtion(PrescribtionEntity pres)
	{
		EntityManager em = JPaUtil.getEntityManager();  
		try {
			em.getTransaction().begin();  
			em.persist(pres);    
			em.getTransaction().commit(); 
		} catch (Exception e) {
			em.getTransaction().rollback();
			e.printStackTrace();
			e.getMessage();
		}
		em.close(); 
		System.out.println("Prescribtion added successfully");		
	}
}
