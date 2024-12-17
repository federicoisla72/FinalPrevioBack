package com.uade.tpo.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.uade.tpo.demo.entity.residente;

public interface residenteRepository extends JpaRepository<residente, Integer> {
    
} 
