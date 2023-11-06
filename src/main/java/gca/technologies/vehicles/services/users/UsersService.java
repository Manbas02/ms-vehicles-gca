package gca.technologies.vehicles.services.users;

import gca.technologies.vehicles.model.Response;
import gca.technologies.vehicles.model.dto.GCAUserPaymentDto;
import gca.technologies.vehicles.model.dto.GCAUsersDto;

public interface UsersService {

    Response getAllUsers();

    Response getUserById(Integer registerId);

    Response addUser(GCAUsersDto user);

    Response deleteUserById(Integer registerId);

    Response addPaymentMethod(GCAUserPaymentDto userPayment);

}
