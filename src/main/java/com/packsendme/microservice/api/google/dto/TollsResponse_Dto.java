package com.packsendme.microservice.api.google.dto;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.packsendme.microservice.api.google.repository.Tolls_Country_Model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TollsResponse_Dto implements Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public boolean status_tolls;
	public Map<String, Integer> tolls = new HashMap<String, Integer>();
	public Map<String, Tolls_Country_Model> costsTolls = new HashMap<String, Tolls_Country_Model>();

}
