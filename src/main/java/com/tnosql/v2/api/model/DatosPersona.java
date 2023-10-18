package com.tnosql.v2.api.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "datosPersona")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DatosPersona {
    /*@Id
    private String id;                      // Identificador único generado por MongoDB*/

    //@Indexed(unique = true)
    @Id
    private String ci;                      // Clave de identificación única de la persona

    private String nombre;                  // Nombre de la persona
    private String apellido;                // Apellido de la persona
    private int edad;                       // Edad de la persona

    /**
     * No se construyen GETTERS y SETTERS porque Lombok los genera automáticamente
     */
}
