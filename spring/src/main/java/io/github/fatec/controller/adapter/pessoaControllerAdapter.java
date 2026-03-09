package io.github.fatec.controller.adapter;

import io.github.fatec.controller.dto.request.pessoaRequest;
import io.github.fatec.controller.dto.response.pessoaResponse;
import io.github.fatec.entity.Pessoa;

import java.util.UUID;

public class pessoaControllerAdapter {
    private pessoaControllerAdapter() {}

    public static Pessoa castRequest(pessoaRequest request) {
        return new Pessoa(
                UUID.randomUUID().toString(),
                request.nome(),
                request.endereco(),
                request.telefone()
        );
    }

    public static pessoaResponse castResponse(Pessoa pessoa) {
        return new pessoaResponse(
                pessoa.id(),
                pessoa.nome(),
                pessoa.endereco(),
                pessoa.telefone());
    }
}
