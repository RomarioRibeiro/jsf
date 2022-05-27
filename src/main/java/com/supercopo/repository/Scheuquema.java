package com.supercopo.repository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.supercopo.model.Empresa;

public class Scheuquema {

	public static void main(String[] args) {
		
		EntityManagerFactory emf = Persistence.createEntityManagerFactory("supercopoPU");
		EntityManager em = emf.createEntityManager();
		
		List<Empresa> list = em.createQuery("from Empresa", Empresa.class).getResultList();
		
		System.out.println(list);
		
		em.close();
		emf.close();
		

	}

}
