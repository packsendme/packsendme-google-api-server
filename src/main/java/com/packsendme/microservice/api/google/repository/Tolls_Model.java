package com.packsendme.microservice.api.google.repository;

import java.io.Serializable;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.Setter;

@Document(collection = "Tolls")
@Getter
@Setter
public class Tolls_Model implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	@Id
	public String id;
	public String nameCountry;
	public Double tollCost;
	
}
