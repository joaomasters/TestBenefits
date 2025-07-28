package com.example.demo.controller;

import com.example.demo.model.Benefit;
import com.example.demo.service.BenefitService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/benefits")
@RequiredArgsConstructor
public class BenefitController {

    private final BenefitService service;

    @GetMapping
    public List<Benefit> listar() {
        return service.listar();
    }

    @PostMapping
    public ResponseEntity<Benefit> criar(@Valid @RequestBody Benefit benefit) {
        return ResponseEntity.ok(service.criar(benefit));
    }

    @PutMapping("/{id}/activate")
    public ResponseEntity<Benefit> ativar(@PathVariable Long id) {
        return ResponseEntity.ok(service.ativar(id));
    }

    @PutMapping("/{id}/deactivate")
    public ResponseEntity<Benefit> desativar(@PathVariable Long id) {
        return ResponseEntity.ok(service.desativar(id));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> excluir(@PathVariable Long id) {
        service.excluir(id);
        return ResponseEntity.noContent().build();
    }
}
