package com.packsendme.microservice.api.google.controller;

import org.springframework.web.bind.annotation.GetMapping;

public class TollsAPI_Controler {

	@GetMapping("/Ricardo")
	public String getString() {
		return "OI";
	}
}
