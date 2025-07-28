package com.seuusuario.beneficiosapi.service;

import com.seuusuario.beneficiosapi.domain.model.Benefit;
import com.seuusuario.beneficiosapi.repository.BenefitRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BenefitService {

    private final BenefitRepository repository;

    public List<Benefit> listar() {
        return repository.findAll();
    }

    public Benefit criar(Benefit benefit) {
        return repository.save(benefit);
    }

    public Benefit ativar(Long id) {
        Benefit b = buscarOuFalhar(id);
        b.setActive(true);
        return repository.save(b);
    }

    public Benefit desativar(Long id) {
        Benefit b = buscarOuFalhar(id);
        b.setActive(false);
        return repository.save(b);
    }

    public void excluir(Long id) {
        repository.deleteById(id);
    }

    private Benefit buscarOuFalhar(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Benefício não encontrado"));
    }
}
