package com.auth.auth.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.auth.Controllers.Dto.CreateUserDto;
import com.auth.auth.Models.UserModel;
import com.auth.auth.Repositories.UserRepository;

import jakarta.validation.Valid;


@RestController
@RequestMapping("/auth")
public class authController {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @GetMapping("/hello")
    public String helloWord(){
        return "hola mundo no seguro";
    }

    @GetMapping("/helloSecured")
    public String helloWordSecured() {
        return "hola mundo seguro";
    }

    @PostMapping("/saveUser")
    public ResponseEntity<Object> createUser(@Valid @RequestBody CreateUserDto createUserDto) {
        UserModel userModel = UserModel.builder()
            .username(createUserDto.getUsername())
            .password(passwordEncoder.encode(createUserDto.getPassword()))
            .email(createUserDto.getEmail())
            .rol(createUserDto.getRol())
            .build();
        
        UserModel data = userRepository.save(userModel);
        return ResponseEntity.ok(data);
    }

    @DeleteMapping("/deleteUser/{id}")
    public String deleteUser(@PathVariable("id") String id) {
        userRepository.deleteById(id);
        return "Usuario Eliminado";
    }
}
