package br.com.pucminas.dad.api.reposiroty;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.pucminas.dad.api.model.Doacao;

public interface DoacaoRepository extends JpaRepository<Doacao, Long> {

}
