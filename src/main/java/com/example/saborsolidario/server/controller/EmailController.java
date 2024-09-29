package com.example.saborsolidario.server.controller;

import com.example.saborsolidario.server.dto.EmailRequest;
import com.example.saborsolidario.server.service.EmailService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/email")
public class EmailController {

    @Autowired
    private EmailService service;

    @PostMapping
    public ResponseEntity<String>enviarEmail(@RequestBody EmailRequest request){
        try{
            service.enviarEmail(request);

            return ResponseEntity.ok("Email enviado com sucesso");

        }catch (Exception e){

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Erro ao enviar email, " + e.getMessage());

        }
    }
}
