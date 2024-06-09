package com.auth.auth.Services;

import java.util.ArrayList;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.auth.auth.Models.RolModel;
import com.auth.auth.Repositories.RolRepository;

@Service
public class RolService {
    @Autowired
    private RolRepository rolRepository;
    
    public class NotFoundException extends RuntimeException {
        public NotFoundException(String message) {
            super(message);
        }
        public NotFoundException(String message, Throwable cause) {
            super(message, cause);
        }
    }

    public ArrayList<RolModel> obtenerRoles() {
        return (ArrayList<RolModel>) rolRepository.findAll();
    }

    public Optional<RolModel> obtenerRolPorId(String id) {
        Optional<RolModel> rol = rolRepository.findById(id);
        if (!rol.isPresent()) {
            throw new NotFoundException("No se encontro el rol con el id proporcianado");
        }
        return rol;
    }

    public RolModel guardarRol(RolModel rol) {
        if (rol.getDescripcion() == null || rol.getDescripcion().isEmpty()) {
            throw new NotFoundException("La descripción del rol está vacía o no está presente");
        }
        if (rol.getEstado() == null || !(rol.getEstado() instanceof Boolean)) {
            throw new NotFoundException("El estado no está presente o no es un valor booleano");
        }
        // Verifica si ya existe un rol con la misma descripción
        if (rolRepository.findByDescripcion(rol.getDescripcion()).isPresent()) {
            throw new NotFoundException("Ya existe un rol con esa descripción");
        }
        rol = rolRepository.save(rol);
        return rol;
    }

    public RolModel updateRol(String id, RolModel rol) {

        if (rol.getDescripcion() == null || rol.getDescripcion().isEmpty()) {
            throw new NotFoundException("La descripción del rol está vacía o no está presente");
        }
        if (rol.getEstado() == null) {
            throw new NotFoundException("El estado no está presente");
        }

        if (rolRepository.findByDescripcion(rol.getDescripcion()).isPresent()) {
            throw new NotFoundException("Ya existe un rol con esa descripción");
        }
        Optional<RolModel> optionalRol = rolRepository.findById(id);
        if (optionalRol.isPresent()) {
            RolModel rolExist = optionalRol.get();
            rolExist.setDescripcion(rol.getDescripcion());
            rolExist.setEstado(rol.getEstado());
            return rolRepository.save(rolExist);
        } else {
            throw new NotFoundException("No se encontro el rol con el id proporcionado");
        }
    }
}
