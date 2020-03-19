package com.packsendme.microservice.api.google.dao;

import java.util.Map;

import com.packsendme.microservice.api.google.dto.TollsResponse_Dto;
import com.packsendme.microservice.api.google.repository.Tolls_Country_Model;

public interface ITolls_DAO {

	public Map<String, Tolls_Country_Model> find(TollsResponse_Dto tollDto);
}
