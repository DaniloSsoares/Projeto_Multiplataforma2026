package io.github.fatec.controller.dto.response;

public record pessoaResponse(
        String id,
        String nome,
        String endereco,
        String telefone
) {
}