package me.dio.academia.digital.controller;

import me.dio.academia.digital.entity.AvaliacaoFisica;
import me.dio.academia.digital.entity.form.AvaliacaoFisicaForm;
import me.dio.academia.digital.service.AvaliacaoFisicaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/avaliacoes")
public class AvaliacaoFisicaController {

    @Autowired
    private AvaliacaoFisicaService service;

    @PostMapping
    public AvaliacaoFisica create(@RequestBody AvaliacaoFisicaForm form) {
        return service.create(form);
    }

    @GetMapping
    public List<AvaliacaoFisica> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public AvaliacaoFisica getById(@PathVariable Long id) {
        return service.getById(id).orElse(null);
    }

    @PutMapping("/{id}")
    public AvaliacaoFisica update(@PathVariable Long id, @RequestBody AvaliacaoFisicaForm form) {
        return service.update(id, form);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id) {
        service.delete(id);
    }
}
