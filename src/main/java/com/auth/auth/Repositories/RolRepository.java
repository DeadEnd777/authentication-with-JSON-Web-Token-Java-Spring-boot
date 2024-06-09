package com.auth.auth.Repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.auth.auth.Models.RolModel;

@Repository
public interface RolRepository extends JpaRepository<RolModel, String> {
    Optional<RolModel> findByDescripcion(String descripcion);
}
