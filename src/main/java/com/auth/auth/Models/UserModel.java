package com.auth.auth.Models;

import org.hibernate.annotations.UuidGenerator;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Builder
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@Entity
@Table(name = "User")
public class UserModel {
    @Id
    @GeneratedValue
    @UuidGenerator
    @Column(name = "id", updatable = false, nullable = false, length = 150)
    private String id;

    @Column(nullable = false, length = 150)
    private String username;
    
    @Column(nullable = false, length = 200)
    private String email;
    
    @Column(nullable = false)
    private String password;

    @ManyToOne
    @JoinColumn(name = "rol", nullable = false)
    private RolModel rol;
}
