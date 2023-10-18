package com.tnosql.v2.api.controller;

import com.tnosql.v2.api.model.Direccion;
import com.tnosql.v2.api.service.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1")
@RequiredArgsConstructor
public class DireccionController {

    /**
     * instancia de DireccionService
     */
    private final DireccionService direccionService;

    @PostMapping("/direccion")
    public void save(@RequestBody Direccion direccion) {
        direccionService.save(direccion);
    }

    /**
     * recurso para obtener todas las direcciones de una persona
     */
    @GetMapping("/direccion/{ci}")
    public List<Direccion> findByCi(@PathVariable String ci) {
        return direccionService.findByCi(ci);
    }

    /**
     * recurso para obtener domcilios segun criterios
     */

    @GetMapping("/direccion")
    public List<Direccion> findByDepartamentoOrLocalidadOrBarrio(@RequestBody Direccion direccion) {
        String departamento = (direccion.getDepartamento() != null) ? direccion.getDepartamento() : "";
        String localidad = (direccion.getLocalidad() != null) ? direccion.getLocalidad() : "";
        String barrio = (direccion.getBarrio() != null) ? direccion.getBarrio() : "";
        return direccionService.findByDepartamentoOrLocalidadOrBarrio(departamento, localidad, barrio);
    }


}
