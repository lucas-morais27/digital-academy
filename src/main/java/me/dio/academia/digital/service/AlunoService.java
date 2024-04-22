package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AlunoForm;
import me.dio.academia.digital.repository.AlunoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AlunoService {

  @Autowired
  private AlunoRepository repository;

  public List<Aluno> getAll() {
    return repository.findAll();
  }

  public Aluno create(AlunoForm form) {
    Aluno aluno = new Aluno();
    aluno.setNome(form.getNome());
    aluno.setCpf(form.getCpf());
    aluno.setBairro(form.getBairro());
    aluno.setDataDeNascimento(form.getDataDeNascimento());

    return repository.save(aluno);
  }

  public List<AvaliacaoFisica> getAllAvaliacaoForId(Long id) {
    Optional<Aluno> alunoOptional = repository.findById(id);
    if (alunoOptional.isPresent()) {
      Aluno aluno = alunoOptional.get();
      return aluno.getAvaliacoes();
    } else {
      // Lidar com o caso em que o aluno com o ID fornecido não é encontrado
      return null; // Ou lançar uma exceção, dependendo do comportamento desejado
    }
  }

  public Aluno update(Long id, AlunoForm form) {
    Optional<Aluno> optionalAluno = repository.findById(id);
    if (optionalAluno.isPresent()) {
      Aluno aluno = optionalAluno.get();
      aluno.setNome(form.getNome());
      aluno.setCpf(form.getCpf());
      aluno.setBairro(form.getBairro());
      aluno.setDataDeNascimento(form.getDataDeNascimento());
      // Talvez você queira adicionar mais lógica de atualização aqui

      return repository.save(aluno);
    } else {
      // Lidar com o caso em que o aluno com o ID fornecido não é encontrado
      return null; // Ou lançar uma exceção, dependendo do comportamento desejado
    }
  }

  public void delete(Long id) {
    repository.deleteById(id);
  }
}
