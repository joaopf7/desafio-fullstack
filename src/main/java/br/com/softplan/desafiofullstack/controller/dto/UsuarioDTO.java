package br.com.softplan.desafiofullstack.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.softplan.desafiofullstack.model.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class UsuarioDTO {

	private Long id;

	private String nome;

	private String login;

	private String senha;
	
	private String perfil;

	public UsuarioDTO(Usuario usuario) {
		this.id = usuario.getId();
		this.nome = usuario.getNome();
		this.login = usuario.getLogin();
		this.senha = usuario.getSenha();
		this.perfil = usuario.getPerfil();
	}
	
	public static List<UsuarioDTO> converter(List<Usuario> usuarios) {
		List<UsuarioDTO> usuariosDTO = new ArrayList<>();
		for(Usuario usuario : usuarios) {
			UsuarioDTO usuarioDTO = new UsuarioDTO(usuario);
			usuariosDTO.add(usuarioDTO);
		}
		return usuariosDTO;
	}

}