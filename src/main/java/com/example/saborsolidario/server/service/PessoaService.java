package com.example.saborsolidario.server.service;

import com.example.saborsolidario.server.dto.PessoaRequest;
import com.example.saborsolidario.server.entity.Pessoa;
import com.example.saborsolidario.server.repository.PessoaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class PessoaService {

    @Autowired
    private PessoaRepository repository;

    public ResponseEntity<String> execute(PessoaRequest request){
        repository.findByEmail(request.email()).ifPresent(user -> {
            throw new RuntimeException("Usuario já existe");
        });

        var usuario = new Pessoa(request);
        repository.save(usuario);


        return ResponseEntity.ok().body("Usuário cadastrado com sucesso!");
    }

}
