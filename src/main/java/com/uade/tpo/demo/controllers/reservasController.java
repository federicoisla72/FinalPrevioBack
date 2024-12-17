package com.uade.tpo.demo.controllers;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.uade.tpo.demo.entity.edificio;
import com.uade.tpo.demo.entity.reservas;
import com.uade.tpo.demo.exceptions.reservaDuplicadaException;
import com.uade.tpo.demo.service.reservasService;

import java.net.URI;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;


@RestController //con esta anotation, este controller recibe request http
@RequestMapping("reservas") //con esta anotation, globalizamos las reservas para que haya (get, put, delete, create).
@CrossOrigin(origins = "http://localhost:5173")
public class reservasController {
    
    @Autowired //inyecta la interfaz de las reservas automaticamente asi desacoplamos la capa de trafico con la de servicio
    private reservasService reservasService;

    @GetMapping //solicitud de tipo get de todas las reservas
    public ResponseEntity<List<reservas>> getReservas ()  {
        return ResponseEntity.ok(reservasService.getReservas());
    }
    
    @GetMapping("/edificios") 
    public ResponseEntity<List<edificio>> getEdificios() {
        return ResponseEntity.ok(reservasService.getEdificios());
    }

    @GetMapping("/{reservaId}") //solicitud de tipo get con id
    public Optional<reservas> getReservasById (@PathVariable Long ReservasId) {  //PathVariable -> por que va a variar de id
        return reservasService.getReservasById(ReservasId);
    }
    
    @PostMapping
    public ResponseEntity<Object> createReserva(@RequestBody ReservaRequest reservaRequest)
            throws reservaDuplicadaException {
        reservas result = reservasService.createReserva(
            reservaRequest.getDni(), 
            reservaRequest.getResidente(),
            reservaRequest.getApellido(),
            reservaRequest.getDireccion(),
            reservaRequest.getNumDepto(),
            reservaRequest.getFecha(),
            reservaRequest.getTurno());
        return ResponseEntity.created(URI.create("/reservas/" + result.getReservaId())).body(result);
    }
    
}
