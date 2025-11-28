package com.poly.bootcamp.gestionPatients.controller;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poly.bootcamp.gestionPatients.entities.Traitement;
import com.poly.bootcamp.gestionPatients.entities.Patient;
import com.poly.bootcamp.gestionPatients.repository.TraitementRepository;
import com.poly.bootcamp.gestionPatients.repository.PatientRepository;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api/patients/{patientId}/traitements")
public class TraitementController {

    @Autowired
    private PatientRepository patientRepo;

    @Autowired
    private TraitementRepository traitementRepo;

    @GetMapping
    public List<Traitement> list(@PathVariable Long patientId) {
        return traitementRepo.findAll();
    }

    @PostMapping
    public Traitement add(@PathVariable Long patientId, @RequestBody Traitement t) {
        Patient p = patientRepo.findById(patientId)
                .orElseThrow(() -> new RuntimeException("Patient introuvable: " + patientId));
        t.setPatient(p);
        return traitementRepo.save(t);
    }
}
