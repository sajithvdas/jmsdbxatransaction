package com.ibsplc.xatransaction.jmsdatabasetxpoc.dao;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Service;

import com.ibsplc.xatransaction.jmsdatabasetxpoc.model.Edifact;

@Service
public class EdifactDAOImpl implements EdifactDAO {

	@PersistenceContext(unitName="PersistenceUnitA")
	private EntityManager entityManager;


	public void persistEdifact(Edifact edifact) {
		entityManager.persist(edifact);
	}

}
