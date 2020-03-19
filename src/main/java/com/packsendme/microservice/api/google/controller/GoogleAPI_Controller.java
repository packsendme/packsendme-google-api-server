package com.packsendme.microservice.api.google.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.packsendme.lib.simulation.request.dto.SimulationRequest_Dto;
import com.packsendme.microservice.api.google.service.DistancePlaceAPI_Service;
import com.packsendme.microservice.api.google.service.Tolls_Service;


@RestController
@RequestMapping("/api/google")
public class GoogleAPI_Controller {

	@Autowired
	private DistancePlaceAPI_Service googleDirection;

	@Autowired
	private Tolls_Service tolls_Service;
	
	@GetMapping("/distance/{origins}/{destinations}")
	public ResponseEntity<?> getDistance(
			@Validated @PathVariable ("origins") String origins,
			@Validated @PathVariable ("destinations") String destinations) throws JsonProcessingException, IOException {		
		return googleDirection.loadDistancesCities(origins, destinations);
	}

	@GetMapping("/tolls/{origins}/")
	public ResponseEntity<?> getTolls(
			@Validated @PathVariable ("origins") String origins) throws JsonProcessingException, IOException {
		ResponseEntity<String> resp = new ResponseEntity<String>(HttpStatus.ACCEPTED);
		System.out.print("origins");
		return resp;
		//return tolls_Service.getTollsAnalyze(simulation);
	}

	// @Validated @RequestBody SimulationRequest_Dto simulation
}
