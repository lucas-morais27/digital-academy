package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Aluno;
import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.repository.AlunoRepository;
import me.dio.academia.digital.repository.AvaliacaoFisicaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AvaliacaoFisicaService {

  @Autowired
  private AvaliacaoFisicaRepository avaliacaoFisicaRepository;

  @Autowired
  private AlunoRepository alunoRepository;

  public AvaliacaoFisica create(AvaliacaoFisicaForm form) {
    AvaliacaoFisica avaliacaoFisica = new AvaliacaoFisica();
    avaliacaoFisica.aluno = alunoRepository.findById(form.alunoId).get();
    avaliacaoFisica.peso = form.peso;
    avaliacaoFisica.altura = form.altura;

    return avaliacaoFisicaRepository.save(avaliacaoFisica);
  }

  public List<AvaliacaoFisica> getAll() {
    return avaliacaoFisicaRepository.findAll();
  }

  public Optional<AvaliacaoFisica> getById(Long id) {
    return avaliacaoFisicaRepository.findById(id);
  }

  public AvaliacaoFisica update(Long id, AvaliacaoFisicaForm form) {
    Optional<AvaliacaoFisica> optionalAvaliacaoFisica = avaliacaoFisicaRepository.findById(id);
    if (optionalAvaliacaoFisica.isPresent()) {
      AvaliacaoFisica avaliacaoFisica = optionalAvaliacaoFisica.get();
      avaliacaoFisica.setPeso(form.getPeso());
      avaliacaoFisica.setAltura(form.getAltura());
      // Talvez você queira adicionar mais lógica de atualização aqui

      return avaliacaoFisicaRepository.save(avaliacaoFisica);
    } else {
      // Lidar com o caso em que a avaliação física com o ID fornecido não é encontrada
      return null; // Ou lançar uma exceção, dependendo do comportamento desejado
    }
  }

  public void delete(Long id) {
    avaliacaoFisicaRepository.deleteById(id);
  }
}
