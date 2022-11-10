package br.com.softplan.desafiofullstack.controller.dto;

import java.util.ArrayList;
import java.util.List;

import br.com.softplan.desafiofullstack.model.Processo;
import br.com.softplan.desafiofullstack.model.Usuario;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

@Data
@Getter
@Setter
public class ProcessoDTO {

	private Long id;

	private String parecer;

	private String descricao;

	private String status;

	private List<Usuario> usuarios;

	public ProcessoDTO(Processo processo) {
		this.id = processo.getId();
		this.parecer = processo.getParecer();
		this.descricao = processo.getDescricao();
		this.status = processo.getStatus();
		this.usuarios = processo.getUsuarios();
	}
	
	public static List<ProcessoDTO> converter(List<Processo> processos) {
		List<ProcessoDTO> processosDTO = new ArrayList<>();
		for(Processo processo : processos) {
			ProcessoDTO processoDTO = new ProcessoDTO(processo);
			processosDTO.add(processoDTO);
		}
		return processosDTO;
	}

}