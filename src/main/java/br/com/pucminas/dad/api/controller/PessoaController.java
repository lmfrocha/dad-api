package br.com.pucminas.dad.api.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.pucminas.dad.api.model.Pessoa;
import br.com.pucminas.dad.api.reposiroty.PessoaRepository;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> listar(){
		return this.pessoaRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Pessoa p){
		this.pessoaRepository.save(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	@GetMapping("/{id}")
	public Pessoa getById(@PathVariable Long id) {
		return this.pessoaRepository.getOne(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		this.pessoaRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deletado com sucesso");
	}
	
	
}
