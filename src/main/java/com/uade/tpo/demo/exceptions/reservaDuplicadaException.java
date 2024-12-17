package com.uade.tpo.demo.exceptions;

import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.http.HttpStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST, reason = "Ya existe una reserva para ese edicio/fecha")
public class reservaDuplicadaException extends RuntimeException {

    public reservaDuplicadaException() {
        super();
    }

    public reservaDuplicadaException(String message) {
        super(message);
    }
}