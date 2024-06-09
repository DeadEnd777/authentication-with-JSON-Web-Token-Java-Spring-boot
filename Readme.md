# Auth Project

Este es un proyecto de ejemplo de autenticación utilizando JSON Web Tokens (JWT) en Spring Boot.

## Instalación

1. Clona este repositorio en tu máquina local:

    ```bash
    git clone https://github.com/tu_usuario/auth.git
    ```

2. Abre el proyecto en tu IDE preferido.

3. Configura la base de datos en `application.properties` según tus preferencias. Aquí tienes un ejemplo de configuración para MySQL:

    ```properties
    spring.application.name=auth
    
    # Configuración de la base de datos
    spring.jpa.hibernate.ddl-auto=update
    spring.datasource.url=jdbc:mysql://localhost:3306/example
    spring.datasource.username=root
    spring.datasource.password=root
    spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
    ```

4. Configura las propiedades de JWT en `application.properties`:

    ```properties
    # JWT
    jwt.secret.key=your_secret_key
    jwt.time.expiration=your_time_of_expiration
    ```

    Asegúrate de reemplazar `your_secret_key` y `your_time_of_expiration` con tus propias claves y tiempo de expiración.

5. Ejecuta la aplicación Spring Boot.

6. La aplicación debería estar disponible en `http://localhost:8080`.

## Uso

- Para autenticarte, haz una solicitud POST a `/auth/login` con las credenciales de usuario.
- Una vez autenticado, recibirás un token JWT en la respuesta.
- Usa este token en las solicitudes posteriores como encabezado de autorización: `Authorization: Bearer tu_token_jwt`.

## Dependencias

- Spring Boot Starter Data JPA
- Spring Boot Starter Security
- Spring Boot Starter Validation
- Spring Boot Starter Web
- Spring Boot DevTools
- MySQL Connector/J
- Lombok
- JJWT API
- JJWT Jackson
- JJWT Impl
- Spring Boot Starter Test
- Spring Security Test
