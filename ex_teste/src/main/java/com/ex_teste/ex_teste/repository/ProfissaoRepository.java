package com.ex_teste.ex_teste.repository;

import com.ex_teste.ex_teste.model.Profissao;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProfissaoRepository extends
        JpaRepository<Profissao, Integer> {
}