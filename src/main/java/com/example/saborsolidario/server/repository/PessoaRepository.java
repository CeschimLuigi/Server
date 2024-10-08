package com.example.saborsolidario.server.repository;

import com.example.saborsolidario.server.entity.Pessoa;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface PessoaRepository extends JpaRepository<Pessoa,Long> {
    Optional<Pessoa> findByEmail(String email);
}
