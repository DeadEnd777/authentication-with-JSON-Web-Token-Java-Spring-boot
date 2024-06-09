package com.auth.auth.Controllers;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;


@RestController
@RequestMapping("/auth")
public class TestRolController {
    
    @GetMapping("/accessAdmin")
    @PreAuthorize("hasRole('ADMINISTRADOR')")
    public String accessAdmin(){
        return "hola has accedido con rol de admin";
    }

    @PreAuthorize("hasRole('ADMINISTRADOR') or hasRole('USER')")
    @GetMapping("/accessUser")
    public String accessUser() {
        return "hola has accedido con rol de user";
    }
}
