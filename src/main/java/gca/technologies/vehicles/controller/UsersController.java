package gca.technologies.vehicles.controller;

import gca.technologies.vehicles.model.Response;
import gca.technologies.vehicles.model.dto.GCAUserPaymentDto;
import gca.technologies.vehicles.model.dto.GCAUsersDto;
import gca.technologies.vehicles.services.users.UsersService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * Conjunto de operaciones para el manejo de usuarios
 */
@Slf4j
@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsersController {

    /**
     * Interfaz que consume el servicio de usuarios
     */
    private final UsersService usersService;

    /**
     * Endpoint encargado de listar toda la información de los usuarios
     * @return devuelve una lista de usuarios
     */
    @GetMapping(value = "/listar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getAllUsers() {
        return usersService.getAllUsers();
    }

    /**
     * Endpoint encargado de recuperar la información de un usuario
     * @return devuelve un solo usuario
     */
    @GetMapping(value = "/recuperar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response getUserById(@RequestParam(name = "idRegistroUsuario") Integer registerId) {
        return usersService.getUserById(registerId);
    }

    /**
     * Endpoint encargado de registrar un usuario
     * @return devuelve el registro de usuario creado
     */
    @PostMapping(value = "/registrar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response addUser(@RequestBody GCAUsersDto request) {
        return usersService.addUser(request);
    }

    /**
     * Endpoint encargado de eliminarun usuario
     * @param registerId Hace referencia al id del usuario a eliminar
     * @return devuelve un mensaje confirmando la eliminacion del usuario
     */
    @DeleteMapping(value = "/eliminar", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUser(@RequestParam(name = "idRegistroUsuario") Integer registerId) {
        return usersService.deleteUserById(registerId);
    }

    /**
     * Endpoint encargado de agregar un medio de pago a un usuario
     * @param request Hace referencia a la información del medio de pago que se va a agregar
     *                al usuario
     * @return devuelve el medio de pago agregado al usuario
     */
    @PostMapping(value = "/agregarMedioDePago", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response addPaymentMethod(@Validated @RequestBody GCAUserPaymentDto request) {
        return usersService.addPaymentMethod(request);
    }

    /**
     *  Endpoint encargado de editar la informacion de un medio de pago de un usuario
     * @param request Hace referencia a la información del medio de pago que se va a editar
     *                y el usuario al que pertenece
     * @return devuelve el medio de pago editado
     */
    @PutMapping(value = "/editarMedioPago", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response updateUserPaymentMethod(@RequestBody GCAUserPaymentDto request) {
        return usersService.updateUserPaymentMethod(request);
    }

    /**
     * Endpoint encargado de eliminar un medio de pago de un usuario
     * @param userPaymentDto Hace referencia a la información del medio de pago que se va a eliminar
     *                       y el usuario al que pertenece
     * @return devuelve un mensaje confirmando la eliminacion del medio de pago
     */
    @DeleteMapping(value = "/eliminarMedioPago", produces = MediaType.APPLICATION_JSON_VALUE)
    public Response deleteUserPaymentMethod(@RequestBody GCAUserPaymentDto userPaymentDto) {
        return usersService.deleteUserPaymentMethod(userPaymentDto);
    }

}
