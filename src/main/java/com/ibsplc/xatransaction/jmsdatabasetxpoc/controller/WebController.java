package com.ibsplc.xatransaction.jmsdatabasetxpoc.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.ibsplc.xatransaction.jmsdatabasetxpoc.model.Edifact;
import com.ibsplc.xatransaction.jmsdatabasetxpoc.service.EdifactService;

@RestController
public class WebController {

	@Autowired
	private EdifactService edifactService;

	@RequestMapping(value = "/send")
	public Object send(@RequestParam(required = true) String pnr, @RequestParam(required = true) String edifactMsg,
			@RequestParam(required = true) long pollStatus) {

		Edifact edifact = new Edifact();
		edifact.setPnr(pnr);
		edifact.setEdifactRaw(edifactMsg);
		edifact.setPollStatus(pollStatus);

		try {
			ObjectMapper mapper = new ObjectMapper();
			String jsonString = mapper.writeValueAsString(edifact);
			edifact.setEifactJson(jsonString);

			edifactService.persistEdifact(edifact);
		} catch (Exception ex) {
			System.err.println();
			return "not ok ->" + ex.getMessage();
		}

		return "ok";
	}
}
