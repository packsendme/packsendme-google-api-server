package com.packsendme.microservice.api.google.dao;

import java.util.Map;

import com.packsendme.microservice.api.google.dto.TollsResponse_Dto;

public interface ITolls_DAO {

	public Map<String, Double> find(TollsResponse_Dto tollDto);
}
