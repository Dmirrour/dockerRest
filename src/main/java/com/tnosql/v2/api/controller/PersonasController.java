package com.tnosql.v2.api.controller;

import com.tnosql.v2.api.model.Personas;
import com.tnosql.v2.api.service.PersonasService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v0")
@RequiredArgsConstructor
public class PersonasController {

    private final PersonasService personasService;

    // recurso para guardar una persona
    @PostMapping("/personas")
    public void save(@RequestBody Personas persona) {
        personasService.save(persona);

        /**
         * Ejemplo de body para guardar una persona:
         * {
         *      "id": "43791806",
         *     "datosPersona": {
         *         "ci": "43791806",
         *         "nombre": "wilson",
         *         "apellido": "arriola",
         *         "edad": 43
         *     },
         *     "direccion": {
         *         "departamento": "Montevideo",
         *         "localidad": "Carrasco",
         *         "calle": "Av. Principal",
         *         "nro": 123,
         *         "apartamento": "A2",
         *         "padrón": "5678",
         *         "ruta": "R10",
         *         "km": 5,
         *         "letra": "B",
         *         "barrio": "Residencial"
         *     }
         * }
         */
    }

    // recurso para obtener todas las personas
    @GetMapping("/personas")
    public List<Personas> getAll() {
        return personasService.findAll();
    }

    // recurso para obtener una persona por su id
    @GetMapping("/personas/{id}")
    public Personas findById(@PathVariable String id) {
        return personasService.findById(id).get();
    }

    // recurso para eliminar una persona por su id
    @DeleteMapping("/personas/{id}")
    public void deleteById(@PathVariable String id) {
        personasService.deleteById(id);
    }

    // recurso para actualizar una persona por su id
    @PutMapping("/personas")
    public void updateById(@RequestBody Personas persona) {
        personasService.save(persona);
    }
}
