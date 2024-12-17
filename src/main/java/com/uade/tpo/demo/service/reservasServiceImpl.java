package com.uade.tpo.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.uade.tpo.demo.entity.edificio;
import com.uade.tpo.demo.entity.reservas;
import com.uade.tpo.demo.exceptions.reservaDuplicadaException;
import com.uade.tpo.demo.repository.edificioRepository;
import com.uade.tpo.demo.repository.reservaRepository;

@Service //con esta anotation, indica que esta va a ser la capa de independencia de servicio 
public class reservasServiceImpl implements reservasService{ //voy a definir los metodos de la capa de trafico // no voy a usar ninguna libreria, voy a usar puro java
    
    @Autowired //inyecto el repository con autowired
    private reservaRepository reservaRepository;

    @Autowired
    private edificioRepository edificioRepository;

    public List<reservas> getReservas() {
        return reservaRepository.findAll(); //con el findAll de jpa me devuleve todas las reservas
    }
    
    public List<edificio> getEdificios() {
        return edificioRepository.findAll();//con el findAll de jpa me devueve todas las reservas
    }

    public Optional<reservas> getReservasById(Long ReservasId) {
        return reservaRepository.findById(ReservasId);
    }
    
    public reservas createReserva (Integer dni, String residente, String apellido, String direccion, Integer numDepto, String fecha, String turno) throws reservaDuplicadaException {
        if (!turno.equalsIgnoreCase("Tarde") && !turno.equalsIgnoreCase("Noche")) {
            throw new IllegalArgumentException("El turno debe ser 'Tarde' o 'Noche'.");
        }
        
        List<reservas> reservaExistentes = reservaRepository.findByDireccionFechaTurno(direccion, fecha, turno);

        if (reservaExistentes.isEmpty()) {
            reservas nuevaReservas = new reservas(fecha, direccion, residente, turno);
            return reservaRepository.save(nuevaReservas);
        }  //aca estoy diciendo que si ya hay una fecha y un edificio que ya existe en la base, entonces rechazo la creacion de la reserva
             
        throw new reservaDuplicadaException("el sum ya esta reservado para la fecha " + fecha + " y turno " + turno);
    }
}
