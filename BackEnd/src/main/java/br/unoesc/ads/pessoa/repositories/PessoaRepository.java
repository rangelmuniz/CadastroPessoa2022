package br.unoesc.ads.pessoa.repositories;

import java.math.BigDecimal;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.unoesc.ads.pessoa.entities.Pessoa;

public interface PessoaRepository extends JpaRepository<Pessoa, Long> {
	@Query("select p from Pessoa p where p.idade >= :idade ")
	List<Pessoa> porIdade(@Param("idade") BigDecimal idade);

}

