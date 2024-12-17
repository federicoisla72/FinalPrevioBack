package com.uade.tpo.demo.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.Data;

@Data //tengo definido todos los getter y setter de mis propiedades para usarlos en otras clases
@Entity
public class residente { //defino los datos que va a tener la reserva

    @Id
    private Integer dni;

    @Column
    private String nombre;

    @Column
    private String apellido;

    @Column
    private String direccion;

    @Column
    private Integer numDepto;
}
