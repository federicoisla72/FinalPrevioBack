package com.uade.tpo.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import com.uade.tpo.demo.entity.edificio;
@Repository
public interface edificioRepository extends JpaRepository<edificio, String> {
    @Query("SELECT e FROM edificio e") // Selecciona solo las direcciones de la entidad
    List<edificio> findAllEdificios(); // Devuelve una lista de Strings con las direcciones
    
    
} 
