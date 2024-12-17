package com.uade.tpo.demo.service;

import java.util.List;
import java.util.Optional;

import com.uade.tpo.demo.entity.edificio;
import com.uade.tpo.demo.entity.reservas;
import com.uade.tpo.demo.exceptions.reservaDuplicadaException;

public interface reservasService {
    
    public List<reservas> getReservas();
    public List<edificio> getEdificios();
    public Optional<reservas> getReservasById (Long ReservasId);
    public reservas createReserva (Integer dni, String residente, String apellido, String direccion, Integer numDepto, String fecha, String turno) throws reservaDuplicadaException ;
    
}
