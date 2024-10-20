package com.example.kargo.controller;

import com.example.kargo.entity.Kargo;
import com.example.kargo.service.KargoService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/kargo")
@RequiredArgsConstructor
public class KargoController {

    private final KargoService kargoService;

    // Tüm kargoları listelemek için GET isteği
    @GetMapping
    public List<Kargo> getAllKargos() {
        return kargoService.getAllKargos();
    }

    // Belirli bir kargoyu ID ile almak için GET isteği
    @GetMapping("/{id}")
    public Kargo getKargoById(@PathVariable Long id) {
        return kargoService.getKargoById(id)
                .orElseThrow(() -> new RuntimeException("Kargo not found with id " + id));
    }

    // Yeni bir kargo eklemek için POST isteği
    @PostMapping
    public Kargo addKargo(@RequestBody Kargo kargo) {
        return kargoService.addKargo(kargo);
    }

    // Var olan bir kargoyu ID ile güncellemek için PUT isteği
    @PutMapping("/{id}")
    public Kargo updateKargo(@PathVariable Long id, @RequestBody Kargo updatedKargo) {
        return kargoService.updateKargo(id, updatedKargo)
                .orElseThrow(() -> new RuntimeException("Kargo not found with id " + id));
    }

    // Belirli bir kargoyu silmek için DELETE isteği
    @DeleteMapping("/{id}")
    public void deleteKargo(@PathVariable Long id) {
        kargoService.deleteKargo(id);
    }
}
