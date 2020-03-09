package com.ibsplc.xatransaction.jmsdatabasetxpoc.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ibsplc.xatransaction.jmsdatabasetxpoc.dao.EdifactDAO;
import com.ibsplc.xatransaction.jmsdatabasetxpoc.model.Edifact;

@Service
public class EdifactServiceImpl implements EdifactService{

    @Autowired
    private JmsTemplate jmsTemplate;
    
    @Autowired
    private EdifactDAO edifactDAO;

	@Transactional
	public void persistEdifact(Edifact edifact) throws Exception {
		edifactDAO.persistEdifact(edifact);
		jmsTemplate.convertAndSend("notification.queue", edifact.getEifactJson());
		
	}

}
