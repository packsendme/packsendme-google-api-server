package com.packsendme.microservice.api.google.service;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.packsendme.lib.common.constants.HttpExceptionPackSend;
import com.packsendme.lib.common.response.Response;
import com.packsendme.microservice.api.google.component.AnalyzeData_Component;
import com.packsendme.microservice.api.google.config.Connection_Config;
import com.packsendme.microservice.api.google.dao.Tolls_DAO;
import com.packsendme.microservice.api.google.dto.TollsResponse_Dto;
import com.packsendme.microservice.api.google.repository.Tolls_Model;
 

@Service
public class Tolls_Service {
	
	@Autowired
	private Connection_Config configuration;

	@Autowired
	private AnalyzeData_Component analyzeData_Component;
	
	@Autowired
	private TollsResponse_Dto tollsResponse_Dto; 
	
	@Autowired
	private Tolls_DAO tolls_DAO;
	

	public ResponseEntity<?> getTollsAnalyze(String origin, String destination) {
		Response<TollsResponse_Dto> responseObj = null;
		String jsonBodyS = null;
		JSONObject jObject = null;
		Map<String, Double> tollCostsMap = null;
		
		try {
			RestTemplate restTemplate = new RestTemplate();
			
			HttpHeaders headers = new HttpHeaders();
			headers.setContentType(MediaType.APPLICATION_JSON);
			headers.setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
			HttpEntity request = new HttpEntity(headers);
			
			Map<String, String> uriParam = new HashMap<>();
		    uriParam.put("origin", origin);
		    uriParam.put("destination", destination);
		    uriParam.put("key", configuration.key_api);
		    uriParam.put("travel_mode", "DRIVING");
		    uriParam.put("avoidTolls", "false");
			
		    ResponseEntity<String> response = restTemplate.exchange(
		    		configuration.direction_api_url,
		    		HttpMethod.GET, 
		    		request,
                    String.class,
                    uriParam);

		    if (response.getStatusCode() == HttpStatus.OK) {
		    	jsonBodyS = response.getBody();
		    	JSONParser parser = new JSONParser();
		    	JSONObject jsonObject = (JSONObject) parser.parse(jsonBodyS);
		    	
		    	if(jsonObject.get("status") == "OK") {
		    		tollsResponse_Dto = analyzeData_Component.analyzeJsonTolls(jsonObject, destination);
		    		responseObj = new Response<TollsResponse_Dto>(0,HttpExceptionPackSend.GOOGLEAPI_PLACE.getAction(), tollsResponse_Dto);
					return new ResponseEntity<>(responseObj, HttpStatus.ACCEPTED);
		    	}
		    	else {
					responseObj = new Response<TollsResponse_Dto>(0,HttpExceptionPackSend.GOOGLEAPI_PLACE.getAction(), null);
					return new ResponseEntity<>(responseObj, HttpStatus.BAD_REQUEST);
		    	}
			}
			else {
				return new ResponseEntity<>(responseObj, HttpStatus.NOT_FOUND);
			}
		}
		catch (Exception e ) {
			e.printStackTrace();
			responseObj = new Response<TollsResponse_Dto>(0,HttpExceptionPackSend.FAIL_EXECUTION.getAction(), null);
			return new ResponseEntity<>(responseObj, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	
	
}
