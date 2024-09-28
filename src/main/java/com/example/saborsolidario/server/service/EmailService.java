package com.example.saborsolidario.server.service;

import com.example.saborsolidario.server.dto.EmailRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

@Service
public class EmailService {

    @Autowired
    private JavaMailSender mailSender;

    public void enviarEmail(EmailRequest request){


        SimpleMailMessage message = new SimpleMailMessage();

        message.setTo("saborsolidariofsaproject@gmail.com");
        message.setFrom(request.email());
        message.setReplyTo(request.email());
        message.setText("Olá sou " + request.nome()  + ",\n\n" + request.mensagem());
        message.setSubject("Sabor Solidário " + "(" + request.nome() + ")");

        mailSender.send(message);

    }
}
