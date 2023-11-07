package gca.technologies.vehicles.controller;

import gca.technologies.vehicles.model.Response;
import gca.technologies.vehicles.model.dto.GCARentDto;
import gca.technologies.vehicles.services.vehicles.VehiclesService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

/**
 * Conjunto de operaciones para el manejo de las rentas de vehiculos
 */
@Slf4j
@RestController
@RequestMapping("/rentaVehiculos")
@RequiredArgsConstructor
public class VehiclesController {

    /**
     * Interfaz que consume el servicio de vehiculos
     */
    private final VehiclesService vehiclesService;

    /**
     * Endpoint encargado de registrar una renta
     *
     * @return devuelve el registro de renta creado
     */
    @PostMapping(value = "/rentar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response rent(@RequestBody GCARentDto request) {
        return vehiclesService.rent(request);
    }

    /**
     * Endpoint encargado de listar toda la información de las rentas
     *
     * @return devuelve una lista de rentas
     */
    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response listRentals() {
        return vehiclesService.listRentals();
    }

    /**
     * Endpoint encargado de recuperar la información de una renta
     *
     * @return devuelve una sola renta
     */
    @PostMapping(value = "/recuperar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response recoverRent(@RequestParam(name = "idRegistro") Integer registerId) {
        return vehiclesService.recoverRent(registerId);
    }

    /**
     * Endpoint encargado de actualizar el estado de una renta
     *
     * @return devuelve el registro de renta actualizado
     */
    @PutMapping(value = "/actualizarEstado", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response updateRentalStatus(@RequestBody GCARentDto request) {
        return vehiclesService.updateRentalStatus(request);
    }


}
