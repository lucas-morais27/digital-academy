package me.dio.academia.digital.service;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.repository.MatriculaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MatriculaService {
    @Autowired
    private MatriculaRepository matriculaRepository;

    public Matricula create(MatriculaForm form) {
        Matricula matricula = new Matricula();
        // Preencher os campos da matrícula com base nos dados do formulário
        // matricula.setXXX(form.getXXX());

        return matriculaRepository.save(matricula);
    }

    public List<Matricula> getAll() {
        return matriculaRepository.findAll();
    }

    public Optional<Matricula> getById(Long id) {
        return matriculaRepository.findById(id);
    }

    public Matricula update(Long id, MatriculaForm form) {
        Optional<Matricula> optionalMatricula = matriculaRepository.findById(id);
        if (optionalMatricula.isPresent()) {
            Matricula matricula = optionalMatricula.get();
            // Atualizar os campos da matrícula com base nos dados do formulário
            // matricula.setXXX(form.getXXX());

            return matriculaRepository.save(matricula);
        } else {
            // Lidar com o caso em que a matrícula com o ID fornecido não é encontrada
            return null; // Ou lançar uma exceção, dependendo do comportamento desejado
        }
    }

    public void delete(Long id) {
        matriculaRepository.deleteById(id);
    }
}
