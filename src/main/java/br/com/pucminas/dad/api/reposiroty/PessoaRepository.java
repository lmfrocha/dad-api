package br.com.pucminas.dad.api.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import br.com.pucminas.dad.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

	@Query(" FROM Pessoa p where p.cpf = ?1")
	public Pessoa findByCpf(Long Cpf);
	
}
