package com.ex_teste.ex_teste.service;
import com.ex_teste.ex_teste.model.Profissao;
import com.ex_teste.ex_teste.repository.ProfissaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.Optional;

@Service
public class ProfissaoService {
@Autowired
private ProfissaoRepository profissaoRepository;
public List<Profissao> getAllProfissoes() {
return profissaoRepository.findAll();
}
public Profissao getProfissaoById(int id) {
Optional<Profissao> profissao = profissaoRepository.findById(id);
return profissao.orElse(null);
}
@Transactional // Garantir que a transação seja executada corretamente
public Profissao saveProfissao(Profissao profissao) {
System.out.println("Salvando profissão: " + profissao.getNome());
Profissao savedProfissao = profissaoRepository.save(profissao);
System.out.println("Profissão salva com ID: " + savedProfissao.getIdProfissao());
return savedProfissao;
}
@Transactional // Garantir transação para atualizações também
public Profissao updateProfissao(int id, Profissao updatedProfissao) {
Optional<Profissao> existingProfissao = profissaoRepository.findById(id);
if (existingProfissao.isPresent()) {
Profissao profissao = existingProfissao.get();
profissao.setNome(updatedProfissao.getNome());
return profissaoRepository.save(profissao);
}
return null;
}
@Transactional

boolean deleteProfissao(int id) {
Optional<Profissao> existingProfissao = profissaoRepository.findById(id);
if (existingProfissao.isPresent()) {
profissaoRepository.deleteById(id);
return true;
}
return false;
}
}