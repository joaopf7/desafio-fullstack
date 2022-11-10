package br.com.softplan.desafiofullstack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softplan.desafiofullstack.model.Processo;


public interface ProcessoRepository extends JpaRepository<Processo, Long> {

	List<Processo> findByDescricao(String descricao);

}
