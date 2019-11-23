package br.com.pucminas.dad.api.controller;

import java.util.ArrayList;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class MainController {

	@GetMapping
	public ResponseEntity<?> hello(){
		
		
		return ResponseEntity.ok().body("[ "
				
				+ "{ "
				+ "\"nome\":\"Ângelo Diniz\""
				+ " }, "
				
				+ "{ "
				+ "\"nome\":\"Alessandra Faria\""
				+ " }, "
				
				+ "{ "
				+ "\"nome\":\"Lucas Rocha\""
				+ " }, "
				
				+ "{ "
				+ "\"nome\":\"Victor de Souza\""
				+ " } "				
				
				+ " ]");
				
	}
	
}
