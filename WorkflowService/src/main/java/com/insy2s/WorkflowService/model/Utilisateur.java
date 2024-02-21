package com.insy2s.WorkflowService.model;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import jakarta.persistence.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String role;

    private String firstName;

    private String lastName;

    private String email;
    @Column(length = 60) // Longueur recommandée pour stocker des hachages de mot de passe
    private String password;
    private String img;
}
