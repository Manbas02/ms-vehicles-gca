package gca.technologies.vehicles.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import gca.technologies.vehicles.model.entity.GCAPaymentsEntity;
import lombok.*;

import java.util.List;

/**
 * Clase encargada de mappear el response para la tabla GCA_USER_PAYMENT
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ResponseUserPaymentDto {

    /**
     * Hace referencia al identificador del usuario
     */
    @JsonProperty("idUsuario")
    private Integer userId;

    /**
     * Hace referencia al usuario
     */
    @JsonProperty("usuario")
    private String userName;

    /**
     * Hace referencia al nombre
     */
    @JsonProperty("nombre")
    private String name;

    /**
     * Hace referencia al apellido
     */
    @JsonProperty("apellido")
    private String lastName;

    /**
     * Hace referencia a la contraseña
     */
    @JsonProperty("contrasena")
    private String password;

    /**
     * Hace referencia a la fecha de registro
     */
    @JsonProperty("fechaRegistro")
    private String registerDate;

    /**
     * Hace referencia a los medios de pago del usuario
     */
    @JsonProperty("MediosDePago")
    private List<GCAPaymentsEntity> paymentType;

}
