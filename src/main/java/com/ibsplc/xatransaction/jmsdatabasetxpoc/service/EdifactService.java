package com.ibsplc.xatransaction.jmsdatabasetxpoc.service;

import com.ibsplc.xatransaction.jmsdatabasetxpoc.model.Edifact;

public interface EdifactService {

	void persistEdifact(Edifact edifact) throws Exception;
}
