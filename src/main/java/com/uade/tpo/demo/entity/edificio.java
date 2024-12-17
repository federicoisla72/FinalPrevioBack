package com.uade.tpo.demo.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data //tengo definido todos los getter y setter de mis propiedades para usarlos en otras clases
@Entity
public class edificio { //defino los datos que va a tener la reserva

    @Id
    private String direccion;
}
