package com.poly.bootcamp.gestionPatients.service;

import java.util.List;
import com.poly.bootcamp.gestionPatients.entities.Patient;

public interface IServicePatient {
    List<Patient> getAllPatients();
    void addPatient(Patient p);
    void deletePatient(Long id);
    List<Patient> getAllPatientByMC(String mc);
}
