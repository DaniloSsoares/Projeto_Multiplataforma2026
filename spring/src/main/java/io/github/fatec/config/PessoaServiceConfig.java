package io.github.fatec.config;

import io.github.fatec.repository.pessoaRepository;
import io.github.fatec.service.PessoaService;
import io.github.fatec.service.PessoaService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
//
@Configuration
public class PessoaServiceConfig {
    @Bean
    public PessoaService pessoaService(pessoaRepository repository){
        return new PessoaService(repository);
    }
}
