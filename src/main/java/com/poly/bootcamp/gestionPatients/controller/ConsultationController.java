package com.poly.bootcamp.gestionPatients.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poly.bootcamp.gestionPatients.entities.Consultation;
import com.poly.bootcamp.gestionPatients.entities.Patient;
import com.poly.bootcamp.gestionPatients.repository.ConsultationRepository;
import com.poly.bootcamp.gestionPatients.repository.PatientRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/patients/{patientId}/consultations")
public class ConsultationController {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private ConsultationRepository consultationRepo;

    @GetMapping
    public List<Consultation> getAll() {
        return consultationRepo.findAll(); // renvoie toutes les consultations
    }

    @PostMapping
    public Consultation add(@PathVariable Long patientId, @RequestBody Consultation c) {
        Patient p = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient introuvable: " + patientId));
        c.setPatient(p);
        return consultationRepo.save(c);
    }
}
