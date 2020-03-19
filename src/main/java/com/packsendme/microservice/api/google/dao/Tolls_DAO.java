package com.packsendme.microservice.api.google.dao;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;

import com.mongodb.MongoClientException;
import com.packsendme.microservice.api.google.dto.TollsResponse_Dto;
import com.packsendme.microservice.api.google.repository.ITolls_Repository;
import com.packsendme.microservice.api.google.repository.Tolls_Country_Model;

public class Tolls_DAO implements ITolls_DAO {

	@Autowired
	ITolls_Repository tolls_Repository;
	
	@Override
	public Map<String, Tolls_Country_Model> find(TollsResponse_Dto tollDto) {
		Tolls_Country_Model tollModel = null;
		Map<String, Tolls_Country_Model> costsTolls = new HashMap<String, Tolls_Country_Model>();
		try {
			for(Map.Entry<String, Integer> entry : tollDto.tolls.entrySet()) {
				tollModel = tolls_Repository.findCostTollByNameContry(entry.getKey());
				costsTolls.put(tollModel.name_country, tollModel);
			}
			return costsTolls;
		}
		catch (MongoClientException e ) {
			e.printStackTrace();
			return null;
		}
	}
	
}
