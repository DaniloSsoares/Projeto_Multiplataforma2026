package io.github.fatec.Integration.dto;

public record govCep ( String cep,
        String tipoCep,
        String subTipoCep,
        String uf,
        String cidade,
        String bairro,
        String endereco,
        String complemento,
        String codigoIBGE
) {
}