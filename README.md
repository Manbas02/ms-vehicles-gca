# ms-vehicles-gca

Servicio API REST para la renta de vehiculos  

## Tabla de Contenido

- [ms-vehicles-gca](#ms-vehicles-gca)
  - [Descripcion](#descripcion)
  - [Endpoints](#endpoints)
  - [Construccion](#construccion)
  - [Ejecucion](#ejecucion)
  
## Descripcion
Se desarrollo un API REST que permite interactuar con los registros de renta de vehiculos y usuarios
con sus respectivos medios de pago para el cual se desarrollo un CRUD para cada uno de los servicios 
con su respectivo conjunto de operaciones.

## Endpoints

Para realizar el consumo del conjunto de operaciones para cada servicio se hizo el despliegue del
proyecto en el servicio de AWS Elastic Beanstalk, el cual se encuentra disponible en el dominio:

[vehicles-gca.us-east-1.elasticbeanstalk.com](vehicles-gca.us-east-1.elasticbeanstalk.com)

Para el consumo de los servicios se debe tener en cuenta que se debe agregar el prefijo a la url
del dominio

### Servicio de usuarios y sus medios de pago

[Controlador Usuarios](src/main/java/gca/technologies/vehicles/controller/UsersController.java)

- [Consultar Usuarios](vehicles-gca.us-east-1.elasticbeanstalk.com/gca-technologies/usuarios/listar) - Al realizar el
consumo de este endpoint se obtiene el listado de todos los usuarios registrados con sus medios de pago
en el sistema.
- [Recuperar Usuario](vehicles-gca.us-east-1.elasticbeanstalk.com/usuarios/recuperar/?idRegistroUsuario=X) -
Al realizar el consumo de este endpoint se puede recuperar especificamente la informacion de un usuario con
registrado por el ID con sus respectivos medios de pago asociados.
- [Registrar Usuario](vehicles-gca.us-east-1.elasticbeanstalk.com/usuarios/registrar) - Al realizar el consumo 
de este endpoint se realiza una inserccion en la base de datos o carga la informacion de un usuario que se ha
registrado en el sistema.
- [Eliminar Usuario](vehicles-gca.us-east-1.elasticbeanstalk.com/usuarios/eliminar/?idRegistroUsuario=X) - Al realizar
el consumo de este endpoint se elimina la informacion de un usuario especifico por el ID.
- [Agregar Medio De pago](vehicles-gca.us-east-1.elasticbeanstalk.com/usuarios/agregarMedioDePago) - Al realizar el
consumo de este endpoint se agrega un medio de pago y se asocia al usuario especificado por el ID.
- [Editar Medio De pago](vehicles-gca.us-east-1.elasticbeanstalk.com/usuarios/editarMedioPago) - Al realizar el
consumo de este endpoint se edita la informacion de un medio de pago especificando el ID del usuario al que esta asociado
el medio de pago y el ID del medio de pago ya que un usuario puede tener muchos medios de pago.
- [Eliminar Medio De pago](vehicles-gca.us-east-1.elasticbeanstalk.com/usuarios/eliminarMedioPago) - Al realizar el
consumo de este endpoint se elimina la informacion de un medio de pago de un usuario especificando el ID del usuario que
- contiene el medio de pago y el ID del medio de pago que se desea eliminar.

### Servicio de renta de vehiculos

[Controlador Rentas](src/main/java/gca/technologies/vehicles/controller/VehiclesController.java)

- [Rentar Vehiculo](vehicles-gca.us-east-1.elasticbeanstalk.com/rentaVehiculos/rentar) - Al realizar el consumo de este
endpoint se realiza la renta de un vehiculo especificando el medio de pago con el que se realizo la renta y su asociacion
de datos con el usuario.
- [Consultar Rentas](vehicles-gca.us-east-1.elasticbeanstalk.com/rentaVehiculos/consultar) - Al realizar el consumo de
este endpoint se obtiene el listado de todas las rentas de vehiculos registradas en el sistema.
- [Consultar Renta](vehicles-gca.us-east-1.elasticbeanstalk.com/rentaVehiculos/recuperar/?idRegistro=X) - Al realizar el 
consumo de este endpoint se obtiene la informacion de una renta especifica por el ID de la renta.
- [Actualizar Estado Renta](vehicles-gca.us-east-1.elasticbeanstalk.com/rentaVehiculos/actualizarEstado) - Al realizar el
consumo de este endpoint se actualiza el estado de una renta especificando el ID de la renta y el estado al que se desea 
actualizar, si la renta cambia a un estado CERRADO, la renta se finaliza y genera la fecha de finalizacion de la renta.  

## Construccion

El codigo se encuentra implementado con la version de Java 17.

Se utilizo:

- Intellij IDEA
- AWS RDS ORACLE
- AWS Elastic Beanstalk
- JVM 17
- Gradle 8.4.0
- Spring Boot 3.1.5

- - -

## Ejecucion

Para levantar el ambiente de desarrollo realice los siguiente:

1. Tenga clonado este repositorio
2. Verfique que la version instalada de Java sea la 17
3. Usando el plugin de gradle de Intellij IDEA ejecute la tarea de clean and build `./gradlew clean build`.
4. Ejecute la tarea de bootRun `./gradlew bootRun`.
