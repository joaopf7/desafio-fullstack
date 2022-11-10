package br.com.softplan.desafiofullstack.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.softplan.desafiofullstack.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	List<Usuario> findByNome(String nome);

}
