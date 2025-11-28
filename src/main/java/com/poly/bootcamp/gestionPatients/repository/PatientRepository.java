package com.poly.bootcamp.gestionPatients.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.poly.bootcamp.gestionPatients.entities.Patient;

public interface PatientRepository extends JpaRepository<Patient, Long> {
    List<Patient> findByNomContainsOrPrenomContains(String nom, String prenom);

    @Query("select p from Patient p where concat(p.nom, ' ', p.prenom) like concat('%',:x,'%')")
    List<Patient> rechercherParNomPrenom(@Param("x") String mc);
}
