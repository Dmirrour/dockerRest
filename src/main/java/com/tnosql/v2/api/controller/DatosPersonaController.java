package com.tnosql.v2.api.controller;

import com.tnosql.v2.api.model.DatosPersona;
import com.tnosql.v2.api.service.DatosPersonaService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DatosPersonaController {

    /**
     * instancia de DatosPersonaService
     */
    private final DatosPersonaService datosPersonaService;

    /**
     * recurso para guardar una persona
     */
    @PostMapping("/personas")
    public ResponseEntity<?> save(@RequestBody DatosPersona datosPersona) {
        boolean saved = datosPersonaService.save(datosPersona);
        if (saved) {
            return ResponseEntity.ok().build(); // HTTP 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("La Persona ya Existe"); // HTTP 401 Unauthorized
        }
    }

}
