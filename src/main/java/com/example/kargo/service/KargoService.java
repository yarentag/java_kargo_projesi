package com.example.kargo.service;

import com.example.kargo.entity.Kargo;
import com.example.kargo.repository.KargoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class KargoService {

    private final KargoRepository kargoRepository;

    @Autowired
    public KargoService(KargoRepository kargoRepository) {
        this.kargoRepository = kargoRepository;
    }

    // Tüm kargoları getir
    public List<Kargo> getAllKargos() {
        return kargoRepository.findAll();
    }

    // Belirli bir kargoyu ID ile getir
    public Optional<Kargo> getKargoById(Long id) {
        return kargoRepository.findById(id);
    }

    // Yeni bir kargo ekle
    public Kargo addKargo(Kargo kargo) {
        return kargoRepository.save(kargo);
    }

    // Var olan bir kargoyu güncelle
    public Optional<Kargo> updateKargo(Long id, Kargo updatedKargo) {
        return kargoRepository.findById(id)
                .map(kargo -> {
                    kargo.setMusteriAdi(updatedKargo.getMusteriAdi());
                    kargo.setAdres(updatedKargo.getAdres());
                    return kargoRepository.save(kargo);
                });
    }

    // Belirli bir kargoyu sil
    public void deleteKargo(Long id) {
        kargoRepository.deleteById(id);
    }
}
