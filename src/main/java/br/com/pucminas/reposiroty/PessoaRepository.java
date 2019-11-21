package br.com.pucminas.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pucminas.dad.api.model.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {

}
