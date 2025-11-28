package com.poly.bootcamp.gestionPatients.entities;

import java.time.LocalDate;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@JsonIgnoreProperties({"hibernateLazyInitializer", "handler"})
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nom;
    private String prenom;
    private LocalDate dateNaissance;
    // telephone en String (meilleur pour les zéros, +, espaces)
    private String numTel;

    private String email;
    private String adresse;
    private String sexe;

    // relations
    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Consultation> consultations;

    @OneToMany(mappedBy = "patient", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
    @JsonIgnore
    private List<Traitement> traitements;
}
