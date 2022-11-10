package br.com.softplan.desafiofullstack.controller.form;

import java.util.List;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

import br.com.softplan.desafiofullstack.model.Processo;
import br.com.softplan.desafiofullstack.model.Usuario;
import br.com.softplan.desafiofullstack.repository.ProcessoRepository;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ProcessoForm {

	@NotNull
	@NotEmpty
	@Length(min = 10)
	private String descricao;
	
	@Length(min = 5)
	private String parecer;

	private List<Usuario> usuarios;
	
	private String status;

	public Processo converter() {
		return new Processo(null, parecer, descricao, status, usuarios);
	}
	
	public Processo update(Long id, ProcessoRepository processoRepository) {
		Processo processo = processoRepository.findById(id).get();
		processo.setParecer(this.parecer);
		processo.setDescricao(this.descricao);
		processo.setStatus(this.status);
		processo.setUsuarios(this.usuarios);
		return processo;
	}
}
