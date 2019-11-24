package br.com.pucminas.dad.api.controller;

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
				+ "\"PUC MINAS\":\"Sistemas de Informação\","
				+ "\"Disciplina\":\"DAD-PQS\","
				+ "\"Professor\":\"Pedro\""
				+ " }, "
				
				+ "{ "
				+ "\"Aluno\":\"Alessandra Faria Abreu\""
				+ " }, "
				
				+ "{ "
				+ "\"Aluno\":\"Angelo José Diniz Gama\""
				+ " }, "
				
				+ "{ "
				+ "\"Aluno\":\"César Augusto Tavares Júnior\""
				+ " }, "

				+ "{ "
				+ "\"Aluno\":\"Lucas Marcelino Ferreira Rocha\""
				+ " }, "
				
				+ "{ "
				+ "\"Aluno\":\"Victor de Souza Rezende\""
				+ " } "				
				
				+ " ]");
				
	}
	
}
