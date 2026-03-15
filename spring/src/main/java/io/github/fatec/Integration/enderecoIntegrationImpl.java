package io.github.fatec.Integration;

import io.github.fatec.entity.endereco;
import io.github.fatec.integration.enderecoIntegration;
import org.springframework.stereotype.Component;

@Component
public class enderecoIntegrationImpl implements enderecoIntegration {
    @Override
    public endereco buscaCep(String cep) {
        System.out.println("BUSCANDO ENDERECO");
        return null;
    }
}
