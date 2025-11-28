package com.poly.bootcamp.gestionPatients.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.poly.bootcamp.gestionPatients.entities.Consultation;

public interface ConsultationRepository extends JpaRepository<Consultation, Long> {
    List<Consultation> findByPatientId(Long patientId);
}
