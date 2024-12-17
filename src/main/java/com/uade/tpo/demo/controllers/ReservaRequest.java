package com.uade.tpo.demo.controllers;

import lombok.Data;

@Data
public class ReservaRequest {
    private String residente;
    private String apellido;
    private Integer dni;
    private String direccion;
    private Integer numDepto;
    private String fecha;
    private String turno;
}
