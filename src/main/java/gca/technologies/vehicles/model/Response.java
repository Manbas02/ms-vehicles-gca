package gca.technologies.vehicles.model;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

/**
 * Clase encargada de manejar la respuesta de los servicios
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Response {

    /**
     * Código de respuesta
     */
    @JsonProperty("codigo")
    private Integer responseCode;

    /**
     * Mensaje de respuesta
     */
    @JsonProperty("mensaje")
    private String responseMessage;

    /**
     * Datos de respuesta
     */
    @JsonProperty("data")
    private Object data;

}
