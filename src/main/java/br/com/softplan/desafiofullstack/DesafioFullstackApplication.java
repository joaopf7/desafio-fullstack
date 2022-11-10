package br.com.softplan.desafiofullstack;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import br.com.softplan.desafiofullstack.model.Processo;
import br.com.softplan.desafiofullstack.repository.ProcessoRepository;

@SpringBootApplication
public class DesafioFullstackApplication {

	public static void main(String[] args) {
		SpringApplication.run(DesafioFullstackApplication.class, args);
	}
	
	@Bean
	CommandLineRunner initDataBase(ProcessoRepository processoRepository) {
		return args -> {
			processoRepository.deleteAll();
			Processo p = new Processo();
			p.setDescricao("Processo Teste!");
			p.setStatus("pendente");
			
			processoRepository.save(p);
		};
	}

}
