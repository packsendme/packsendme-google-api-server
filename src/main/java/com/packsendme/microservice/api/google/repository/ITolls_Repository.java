package com.packsendme.microservice.api.google.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

public interface ITolls_Repository extends MongoRepository<Tolls_Country_Model, String> {
	
	@Query("{'name_country' :  {$eq: ?0}}")
	Tolls_Country_Model findCostTollByNameContry(String name_country);
}
