package com.poly.bootcamp.gestionPatients.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.bootcamp.gestionPatients.entities.Traitement;

public interface TraitementRepository extends JpaRepository<Traitement, Long> {
    List<Traitement> findByPatientId(Long patientId);
}
