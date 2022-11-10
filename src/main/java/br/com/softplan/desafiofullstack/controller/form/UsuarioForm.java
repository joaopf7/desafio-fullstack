package br.com.softplan.desafiofullstack.controller.form;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.softplan.desafiofullstack.model.Usuario;
import br.com.softplan.desafiofullstack.repository.UsuarioRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class UsuarioForm {

	@NotNull
	@NotEmpty
	@Length(min = 5)
	private String nome;

	@Length(min = 5)
	private String login;

	private String senha;
	
	private String perfil;
	
	public Usuario converter() {
		return new Usuario(null, nome, login, senha, perfil);
	}
	
	public Usuario update(Long id, UsuarioRepository usuarioRepository) {
		Usuario usuario = usuarioRepository.findById(id).get();
		usuario.setNome(this.nome);
		usuario.setLogin(this.login);
		usuario.setSenha(this.senha);
		usuario.setPerfil(this.perfil);
		return usuario;
	}
}
