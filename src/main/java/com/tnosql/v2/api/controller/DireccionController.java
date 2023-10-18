package com.tnosql.v2.api.controller;

import com.tnosql.v2.api.model.Direccion;
import com.tnosql.v2.api.service.DireccionService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<?> save(@RequestBody Direccion direccion) {
        boolean saved =direccionService.save(direccion);
        if (saved) {
            return ResponseEntity.ok().build(); // HTTP 200 OK
        } else {
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body("No existe una persona con la cédula aportada como parámetro");
        }
    }

    /**
     * recurso para obtener todas las direcciones de una persona
     */
    @GetMapping("/direccion/{ci}")
    public ResponseEntity<?> findByCi(@PathVariable String ci) {
        List<Direccion> aretornar= direccionService.findByCi(ci);
        if(!aretornar.isEmpty()){
            return ResponseEntity.ok(aretornar);
        }else{
            return ResponseEntity.status(HttpStatus.PAYMENT_REQUIRED).body("No existe una persona con la cédula aportada como parámetro");
        }
    }

    /**
     * recurso para obtener domcilios segun criterios
     */

    /*@GetMapping("/direccion")
    public List<Direccion> findByDepartamentoOrLocalidadOrBarrio(@RequestBody Direccion direccion) {
        String departamento = (direccion.getDepartamento() != null) ? direccion.getDepartamento() : "";
        String localidad = (direccion.getLocalidad() != null) ? direccion.getLocalidad() : "";
        String barrio = (direccion.getBarrio() != null) ? direccion.getBarrio() : "";
        return direccionService.findByDepartamentoOrLocalidadOrBarrio(departamento, localidad, barrio);
    }*/
    @GetMapping("/direccion")
    public List<Direccion> findByDepartamentoOrLocalidadOrBarrio(
            @RequestParam(name = "departamento", required = false) String departamento,
            @RequestParam(name = "localidad", required = false) String localidad,
            @RequestParam(name = "barrio", required = false) String barrio) {
        return direccionService.findByDepartamentoOrLocalidadOrBarrio(departamento, localidad, barrio);
    }


}
