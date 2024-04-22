package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.Matricula;
import me.dio.academia.digital.entity.form.MatriculaForm;
import me.dio.academia.digital.service.MatriculaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/matriculas")
public class MatriculaController {

    @Autowired
    private MatriculaService service;

    @GetMapping
    public List<Matricula> getAll() {
        return service.getAll();
    }

    @PostMapping
    public Matricula create(@RequestBody MatriculaForm form) {
        return service.create(form);
    }

    @GetMapping("/{id}")
    public Matricula getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public Matricula update(@PathVariable Long id, @RequestBody MatriculaForm form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
