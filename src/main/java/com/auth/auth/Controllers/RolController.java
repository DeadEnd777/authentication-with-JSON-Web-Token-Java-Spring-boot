package com.auth.auth.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.auth.auth.Models.RolModel;
import com.auth.auth.Services.RolService;
import com.auth.auth.Services.RolService.NotFoundException;

@RestController
@RequestMapping("/rol")
public class RolController {
    @Autowired
    private RolService rolService;

    @GetMapping("/obtenerRoles")
    public ResponseEntity<Object> obtenerRoles() {
        try {
            return ResponseEntity.ok(rolService.obtenerRoles());
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @GetMapping("/obtenerRolPorId/{id}")
    public ResponseEntity<Object> obtenerRolPorId(@PathVariable("id") String id) {
        try {
            return ResponseEntity.ok(rolService.obtenerRolPorId(id));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(e.getMessage());
        }
    }

    @PostMapping("/guardarRol")
    public ResponseEntity<Object> saveRol(@RequestBody RolModel rol) {
        try {
            return ResponseEntity.ok(rolService.guardarRol(rol));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }

    @PutMapping("/editarRol/{id}")
    public ResponseEntity<Object> updateRol(@PathVariable("id") String id, @RequestBody RolModel rol) {
        try {
            return ResponseEntity.ok(rolService.updateRol(id, rol));
        } catch (NotFoundException e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(e.getMessage());
        }
    }
}
