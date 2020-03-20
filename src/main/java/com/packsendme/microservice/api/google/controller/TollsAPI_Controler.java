package com.packsendme.microservice.api.google.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TollsAPI_Controler {

	@GetMapping("/Ricardo")
	public String getString() {
		return "OI";
	}
}
