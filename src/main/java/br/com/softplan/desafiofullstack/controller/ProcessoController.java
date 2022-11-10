package br.com.softplan.desafiofullstack.controller;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import br.com.softplan.desafiofullstack.controller.dto.ProcessoDTO;
import br.com.softplan.desafiofullstack.controller.form.ProcessoForm;
import br.com.softplan.desafiofullstack.model.Processo;
import br.com.softplan.desafiofullstack.repository.ProcessoRepository;
import io.swagger.annotations.Api;

@RestController
@RequestMapping("/processos")
@Api("Processos")
public class ProcessoController {

	@Autowired
	private ProcessoRepository processoRepository;

	@GetMapping
	public ResponseEntity<List<ProcessoDTO>> lista(@RequestParam(required = false) String descricao) {

		if (descricao == null) {
			List<Processo> processos = processoRepository.findAll();
			return ResponseEntity.ok(ProcessoDTO.converter(processos));
		} else {
			List<Processo> processos = processoRepository.findByDescricao(descricao);
			return ResponseEntity.ok(ProcessoDTO.converter(processos));
		}
	}

	@PostMapping

	@Transactional
	public ResponseEntity<ProcessoDTO> cadastrar(@RequestBody @Valid ProcessoForm form,
			UriComponentsBuilder uriBuilder) {
		Processo processo = form.converter();
		processoRepository.save(processo);

		URI uri = uriBuilder.path("/processos/{id}").buildAndExpand(processo.getId()).toUri();
		return ResponseEntity.created(uri).body(new ProcessoDTO(processo));
	}

	@GetMapping("/{id}")
	public ResponseEntity<ProcessoDTO> detalhar(@PathVariable Long id) {
		Optional<Processo> processo = processoRepository.findById(id);
		if (processo.isPresent()) {
			return ResponseEntity.ok(new ProcessoDTO(processo.get()));
		}

		return ResponseEntity.notFound().build();
	}

	@PutMapping("/{id}")
	@Transactional
	public ResponseEntity<ProcessoDTO> atualizar(@PathVariable Long id, @RequestBody @Valid ProcessoForm form) {
		Optional<Processo> optional = processoRepository.findById(id);
		if (optional.isPresent()) {
			Processo processo = form.update(id, processoRepository);
			return ResponseEntity.ok(new ProcessoDTO(processo));
		}

		return ResponseEntity.notFound().build();
	}

	@DeleteMapping("/{id}")
	@Transactional
	public ResponseEntity<?> remover(@PathVariable Long id) {
		Optional<Processo> optional = processoRepository.findById(id);
		if (optional.isPresent()) {
			processoRepository.deleteById(id);
			return ResponseEntity.ok().build();
		}

		return ResponseEntity.notFound().build();
	}

}
