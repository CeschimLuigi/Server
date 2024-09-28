package com.example.saborsolidario.server.entity;

import com.example.saborsolidario.server.dto.PessoaRequest;
import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "pessoas")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Pessoa {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotBlank
    private String nome;

    private String descricao;

    @Email(message = "Email deve ser válido")
    @NotBlank(message = "Email é obrigatório")
    private String email;

    private Boolean presencaConfirmada = false;

    private String telefone;

    public Pessoa(PessoaRequest request){
        this.nome = request.nome();
        this.email = request.email();
        this.telefone = request.telefone();
        this.descricao = request.descricao();

    }

}
