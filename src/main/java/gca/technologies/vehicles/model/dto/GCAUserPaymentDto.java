package gca.technologies.vehicles.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

/**
 * Clase encargada de mappear el request para la tabla GCA_USER_PAYMENT
 */
@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GCAUserPaymentDto {

    /**
     * Hace referencia al identificador de la tabla
     */
    @JsonProperty("usuario")
    private Integer userId;

    /**
     * Hace referencia al medio de pago
     */
    @JsonProperty("medioPago")
    private GCAPaymentDto paymentData;

}
