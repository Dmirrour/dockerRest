package com.tnosql.v2.api.service;

import com.tnosql.v2.api.model.Direccion;
import com.tnosql.v2.api.repository.DatosPersonaRepository;
import com.tnosql.v2.api.repository.DireccionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DireccionService {

    /**
     * inyeccion de dependencias
     */
    private final DireccionRepository direccionRepository;
    /**
     * inyeccion de dependencias
     */
    private final DatosPersonaRepository datosPersonaRepository;

    /**
     * metodo para obtener todas las direcciones
     */
    public boolean existeCi(String ci) {
        return datosPersonaRepository.existsById(ci);
    }

    /**
     * metodo para guardar una direccion, luego de comprobar que no existe en la base de datos
     * recibe como paremetros una ci y un objeto direccion
     */
    public void save(Direccion direccion) {
        if (existeCi(direccion.getCi())) {
            direccionRepository.save(direccion);
        } else {
            System.out.println("Error 402: No existe una persona con ese ci");
        }
    }

    /**
     * lista direccion segun un parametro ci
     */
    public List<Direccion> findByCi(String ci) {
        return direccionRepository.findByCi(ci);
    }

    /**
     * lista de Direcciones segun un criterio
     * argumentos: departamento, localidad, barrio
     */
    public List<Direccion> findByDepartamentoOrLocalidadOrBarrio(String departamento, String localidad, String barrio) {
        return direccionRepository.findByDepartamentoOrLocalidadOrBarrio(departamento, localidad, barrio);
    }

}
