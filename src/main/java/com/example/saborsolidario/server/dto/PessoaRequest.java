package com.example.saborsolidario.server.dto;

public record PessoaRequest(

        String nome,
        String descricao,
        String email,
        String telefone
) {
}
