package gca.technologies.vehicles.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.Column;
import lombok.*;

import javax.validation.constraints.Pattern;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GCAUsersDto {

    /**
     * Hace referencia al nombre de usuario
     */
    @JsonProperty("usuario")
    @Pattern(regexp = "^[a-zA-Z0-9]+$", message = "El nombre de usuario solo puede contener letras y numeros")
    private String userName;

    /**
     * Hace referencia al nombre
     */
    @JsonProperty("nombres")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "El nombre solo puede contener letras")
    private String name;

    /**
     * Hace referencia al apellido
     */
    @JsonProperty("apellidos")
    @Pattern(regexp = "^[a-zA-Z ]*$", message = "El apellido solo puede contener letras")
    private String lastName;

    /**
     * Hace referencia a la contraseña
     */
    @JsonProperty("contrasena")
    private String password;

}
