package br.com.pucminas.dad.api.service;

import java.util.Date;

import javax.validation.ValidationException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.HttpClientErrorException;

import br.com.pucminas.dad.api.model.Doacao;
import br.com.pucminas.dad.api.model.Pessoa;
import br.com.pucminas.dad.api.reposiroty.DoacaoRepository;
import br.com.pucminas.dad.api.reposiroty.PessoaRepository;

@Service
public class ApiService {

	@Autowired
	private DoacaoRepository doacaoRepository;
	
	@Autowired
	private PessoaRepository pessoaRepository;
	
	public ResponseEntity<?> cadastrarDoacao(Doacao d){
		if(d == null) {
			throw new ValidationException("Erro ao cadastrar Doação");
		}
		if(d.getCpf() == null) {
			throw new ValidationException("Cpf invalido");
		}
		
		Pessoa p = this.pessoaRepository.findByCpf(d.getCpf());
		
		if(p == null) {
			throw new HttpClientErrorException(HttpStatus.NOT_FOUND);
		}
		
		d.setDoador(p);
		d.setCpf(p.getCpf());
		d.setData(new Date());
		this.doacaoRepository.save(d);
		
		return ResponseEntity.status(HttpStatus.CREATED).body(d);
	}
	
	public Pessoa findPessoaByCpf(Long cpf) {
		return pessoaRepository.findByCpf(cpf);
	}
	
}
