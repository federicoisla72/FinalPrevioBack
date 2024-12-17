package com.uade.tpo.demo.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;

@Data //tengo definido todos los getter y setter de mis propiedades para usarlos en otras clases
@Entity //esta entidad va a ser persistida en mi base de datos como una tabla relacional
public class reservas { //defino los datos que va a tener la reserva

    public reservas(){} //hibernate necesita si o si un constructor vacio para la base de datos.

    public reservas(String fecha, String direccion, String residente, String turno) {
        this.fecha = fecha;
        this.direccion = direccion;
        this.residente = residente;
        this.turno = turno;
    }

    @Id //especifica la primary key de mi entidad
    @GeneratedValue(strategy = GenerationType.IDENTITY) //cada vez que se crea un objeto del tipo reserva, la columna id va a generar los id's solos y en orden
    private Long reservaId;

    @Column
    private String fecha;

    @Column
    private String direccion;

    @Column
    private String residente;

    @Column
    private String turno;
}
