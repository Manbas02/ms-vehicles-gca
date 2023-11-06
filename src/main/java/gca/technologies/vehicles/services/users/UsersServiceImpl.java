package gca.technologies.vehicles.services.users;

import gca.technologies.vehicles.model.Response;
import gca.technologies.vehicles.model.dto.GCAUserPaymentDto;
import gca.technologies.vehicles.model.dto.GCAUsersDto;
import gca.technologies.vehicles.model.entity.GCAUsersEntity;
import gca.technologies.vehicles.repository.UsersRepository;
import gca.technologies.vehicles.util.Constants;
import gca.technologies.vehicles.util.GenericServices;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

@Slf4j
@Service
@RequiredArgsConstructor
public class UsersServiceImpl implements UsersService {

    private final UsersRepository usersRepository;

    @Override
    public Response getAllUsers() {
        List<GCAUsersEntity> usersList = usersRepository.findAll();
        return GenericServices.buildResponse(Constants.OK.getResponseCode(), Constants.OK.getMessage(), usersList);
    }

    @Override
    public Response getUserById(Integer registerId) {
        GCAUsersEntity gcaUsersEntity = usersRepository.findById(registerId).orElseThrow(() -> new RuntimeException("No se encontró el usuario con id: " + registerId));
        return GenericServices.buildResponse(Constants.OK.getResponseCode(), Constants.OK.getMessage(), gcaUsersEntity);
    }

    @Override
    public Response addUser(GCAUsersDto user) {
        LocalDateTime registerDate = LocalDateTime.now();
        DateTimeFormatter formato = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
        String date = registerDate.format(formato);
        GCAUsersEntity usersEntity = GCAUsersEntity.builder()
                .userName(user.getUserName())
                .name(user.getName())
                .lastName(user.getLastName())
                .password(user.getPassword())
                .registerDate(date)
                .build();
        usersRepository.save(usersEntity);
        return GenericServices.buildResponse(Constants.OK.getResponseCode(), Constants.OK.getMessage(), usersEntity);
    }

    @Override
    public Response deleteUserById(Integer registerId) {
        getUserById(registerId);
        usersRepository.deleteById(registerId);
        return GenericServices.buildResponse(Constants.OK.getResponseCode(), Constants.OK.getMessage(), null);
    }

    @Override
    public Response addPaymentMethod(GCAUserPaymentDto userPayment) {
        GCAUsersEntity user = (GCAUsersEntity) getUserById(userPayment.getUserId()).getData();

        return null;
    }
}
