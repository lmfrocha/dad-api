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

import br.com.pucminas.dad.api.model.Doacao;
import br.com.pucminas.dad.api.model.Pessoa;
import br.com.pucminas.dad.api.reposiroty.DoacaoRepository;
import br.com.pucminas.dad.api.service.ApiService;

@RestController
@RequestMapping("doacao")
public class DoacaoController {

	@Autowired
	private DoacaoRepository doacaoRepository;
	
	@Autowired
	private ApiService apiService;
	
	@GetMapping
	public List<Doacao> listar(){
		return this.doacaoRepository.findAll();
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Doacao d){
		Pessoa p = this.apiService.findPessoaByCpf(d.getCpf()); 
		if(p != null){
			this.apiService.cadastrarDoacao(d);
		}
		return ResponseEntity.status(HttpStatus.CREATED).body(d);
	}
	
	@GetMapping("/{id}")
	public Doacao getById(@PathVariable Long id) {
		return this.doacaoRepository.getOne(id);
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		this.doacaoRepository.deleteById(id);
		return ResponseEntity.status(HttpStatus.ACCEPTED).body("Deletado com sucesso");
	}
	
	
}
