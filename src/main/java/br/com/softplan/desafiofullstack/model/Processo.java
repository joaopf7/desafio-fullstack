package br.com.softplan.desafiofullstack.model;

import java.io.Serializable;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonProperty;

import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "processos")
@SequenceGenerator(name = "processo_id_seq", sequenceName = "processo_id_seq", initialValue = 1, allocationSize = 1)
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@EqualsAndHashCode
public class Processo implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(generator = "processo_id_seq", strategy = GenerationType.SEQUENCE)
	@Column(name = "processo_id", nullable = false)
	@JsonProperty("_id")
	private Long id;

	@Column(name = "parecer", length = 255)
	private String parecer;

	@Column(name = "descricao", nullable = false)
	private String descricao;
	
	@Column(name = "status", nullable = false)
	private String status;

	@ManyToMany
	@JoinTable(
			  name = "processo_usuario", 
			  joinColumns = @JoinColumn(name = "processo_id"), 
			  inverseJoinColumns = @JoinColumn(name = "usuario_id"))
	private List<Usuario> usuarios;

}

