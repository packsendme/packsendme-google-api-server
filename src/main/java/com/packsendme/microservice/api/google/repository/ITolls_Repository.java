package com.packsendme.microservice.api.google.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ITolls_Repository extends MongoRepository<Tolls_Model, String> {
	
	@Query("{'nameCountry' :  {$eq: ?0}}")
	Tolls_Model findCostTollByNameContry(String nameCountry);
}
