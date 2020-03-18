package com.packsendme.microservice.api.google.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ConfigurationProperties(prefix="packsendme-roadwaysa-server")
public class Connection_Config {

	@Value(value = "${direction.api.url}")
	public String direction_api_url;
	
	@Value(value = "${distance.api.url}")
	public String distance_api_url;
	
	@Value(value = "${api.key}")
	public String key_api;
	
	
}
