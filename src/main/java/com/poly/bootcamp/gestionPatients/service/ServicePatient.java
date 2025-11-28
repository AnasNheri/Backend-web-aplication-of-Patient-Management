package com.poly.bootcamp.gestionPatients.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.poly.bootcamp.gestionPatients.entities.Patient;
import com.poly.bootcamp.gestionPatients.repository.PatientRepository;

@Service
public class ServicePatient implements IServicePatient {

    @Autowired
    private PatientRepository pr;

    @Override
    public List<Patient> getAllPatients() {
        return pr.findAll();
    }

    @Override
    public void addPatient(Patient p) {
        pr.save(p);
    }

    @Override
    public void deletePatient(Long id) {
        pr.deleteById(id);
    }

    @Override
    public List<Patient> getAllPatientByMC(String mc) {
        if (mc == null || mc.isBlank()) return pr.findAll();
        return pr.rechercherParNomPrenom(mc);
    }
}
