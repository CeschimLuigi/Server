package com.example.saborsolidario.server.controller;

import com.example.saborsolidario.server.dto.PessoaRequest;
import com.example.saborsolidario.server.service.PessoaService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/cadastro")
public class PessoaController {

    @Autowired
    private PessoaService service;


    public ResponseEntity<String>cadastrar(@Valid @RequestBody PessoaRequest request){

       return service.execute(request);




    }
}
