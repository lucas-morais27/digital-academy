package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AlunoService {

  @Autowired
  private AlunoRepository repository;

  public List<Aluno> getAll() {
    return repository.findAll();
  }

  public Aluno create(AlunoForm form) {
    Aluno aluno = new Aluno();
    aluno.nome = form.nome;
    aluno.cpf = form.cpf;
    aluno.bairro = form.bairro;
    aluno.dataDeNascimento = form.dataDeNascimento;

    return repository.save(aluno);
  }

  public List<AvaliacaoFisica> getAllAvaliacaoForId(Long id) {
    Aluno aluno = repository.findById(id).get();
    return aluno.avaliacoes;
  }
}
