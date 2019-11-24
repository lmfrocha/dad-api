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
import br.com.pucminas.dad.api.reposiroty.PessoaRepository;

@RestController
@RequestMapping("pessoa")
public class PessoaController {

	@Autowired
	private PessoaRepository pessoaRepository;
	
	@GetMapping
	public List<Pessoa> listar(){
		List<Pessoa> p = this.pessoaRepository.findAll();
		for(int i = 0; i <p.size(); i++) {
			List<Doacao> d = p.get(i).getDoacoes();
			Double valor = 0D;
			for(int x = 0; x<d.size(); x++) {
				valor +=d.get(x).getValor();
			}
			p.get(i).setSaldoDoacoes(valor);
		}
		return p;
	}
	
	@PostMapping
	public ResponseEntity<?> cadastrar(@RequestBody Pessoa p){
		this.pessoaRepository.save(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	@PostMapping("/lista")
	public ResponseEntity<?> cadastrar(@RequestBody List<Pessoa> p){
		this.pessoaRepository.saveAll(p);
		return ResponseEntity.status(HttpStatus.CREATED).body(p);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<?> getById(@PathVariable Long id) {
		if(this.pessoaRepository.existsById(id)) {
			Pessoa p = this.pessoaRepository.getOne(id);
			List<Doacao> d = p.getDoacoes();
			Double valor = 0D;
			for(int x = 0; x<d.size(); x++) {
				valor +=d.get(x).getValor();
			}
			p.setSaldoDoacoes(valor);
			return ResponseEntity.status(HttpStatus.FOUND).body(this.pessoaRepository.getOne(id));
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
	}
	
	@DeleteMapping("/{id}")
	public ResponseEntity<?> deleteById(@PathVariable Long id) {
		Pessoa p = this.pessoaRepository.getOne(id);
		if(p != null) {
			this.pessoaRepository.delete(p);
			return ResponseEntity.ok().body("Pessoa Deletada!");
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).body("Pessoa não encontrada!");
	}
	
	
}
