package com.uade.tpo.demo.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
    
import com.uade.tpo.demo.entity.reservas;

@Repository
public interface reservaRepository extends JpaRepository<reservas, Long> { //voy a trabajar con Jparepository y con la entidad de <reservas> y long (su primary key)
    // Consulta personalizada para encontrar reservas con dirección, fecha y turno específicos
    @Query("SELECT r FROM reservas r WHERE r.direccion = :direccion AND r.fecha = :fecha AND r.turno = :turno")
    List<reservas> findByDireccionFechaTurno(
        @Param("direccion") String direccion,
        @Param("fecha") String fecha,
        @Param("turno") String turno
    );

    // Consultas generadas automáticamente por Spring Data JPA
    List<reservas> findByDireccion(String direccion);
    List<reservas> findByFecha(String fecha);
    List<reservas> findByTurno(String turno);
}
//?1 -> toma el primer parametro (direccion) que se encuentra en la linea 14 y ejecuta la comparativa de que si hay una dirección repetida.