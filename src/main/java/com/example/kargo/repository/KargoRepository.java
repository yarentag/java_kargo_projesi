package com.example.kargo.repository;

import com.example.kargo.entity.Kargo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KargoRepository extends JpaRepository<Kargo, Long> {
    // JPA CRUD işlemlerini sağlayacak
}
