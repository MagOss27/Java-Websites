package com.ex_teste.ex_teste.controller;

import com.ex_teste.ex_teste.model.Profissao;

import com.ex_teste.ex_teste.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/profissoes")
public class ProfissaoController {
    @Autowired
    private ProfissaoRepository profissaoRepository;

    @GetMapping
    public List<Profissao> getAllProfissoes() {
        return profissaoRepository.findAll();
    }

    @PostMapping
    public Profissao createProfissao(@RequestBody Profissao profissao) {
        return profissaoRepository.save(profissao);
    }
}