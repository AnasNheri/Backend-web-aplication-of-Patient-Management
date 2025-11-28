package com.poly.bootcamp.gestionPatients.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.poly.bootcamp.gestionPatients.entities.Patient;
import com.poly.bootcamp.gestionPatients.service.IServicePatient;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
@RequestMapping("/api")
public class PatientController {

    @Autowired
    private IServicePatient sp;

    // GET /api/patients  (optionnel ?mc=motCle)
    @GetMapping("/patients")
    public List<Patient> getPatients(@RequestParam(required = false) String mc){
        if (mc == null || mc.isBlank()) {
            return sp.getAllPatients();
        }
        return sp.getAllPatientByMC(mc);
    }

    // POST /api/patients
    @PostMapping("/patients")
    public Patient addPatient(@RequestBody Patient p) {
        sp.addPatient(p);
        return p;
    }

    // DELETE /api/patients/{id}
    @DeleteMapping("/patients/{id}")
    public void deletePatient(@PathVariable Long id) {
        sp.deletePatient(id);
    }
}
