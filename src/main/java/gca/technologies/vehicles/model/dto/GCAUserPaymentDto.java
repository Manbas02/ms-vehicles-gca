package gca.technologies.vehicles.model.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class GCAUserPaymentDto {

    @JsonProperty("usuario")
    private Integer userId;

    @JsonProperty("medioPago")
    private GCAPaymentDto paymentData;

}
