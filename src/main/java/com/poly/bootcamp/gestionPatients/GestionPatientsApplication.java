package com.poly.bootcamp.gestionPatients;

import java.time.LocalDate;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.poly.bootcamp.gestionPatients.entities.Patient;
import com.poly.bootcamp.gestionPatients.entities.Consultation;
import com.poly.bootcamp.gestionPatients.entities.Traitement;
import com.poly.bootcamp.gestionPatients.repository.PatientRepository;
import com.poly.bootcamp.gestionPatients.repository.ConsultationRepository;
import com.poly.bootcamp.gestionPatients.repository.TraitementRepository;

@SpringBootApplication
public class GestionPatientsApplication {

    @Bean
    CommandLineRunner command(PatientRepository pr, ConsultationRepository cr, TraitementRepository tr) {
        return args -> {
            Patient p1 = pr.save(new Patient(null, "Mohamed", "Ali", LocalDate.of(1990,1,1), "11111111", "mohamed@example.com", "Tunis", "M", null, null));
            Patient p2 = pr.save(new Patient(null, "Sarra", "Mariem", LocalDate.of(1992,2,2), "22222222", "sarra@example.com", "Sfax", "F", null, null));

            cr.save(new Consultation(null, LocalDate.now(), "Contrôle général", "Rien d'inhabituel", p1));
            tr.save(new Traitement(null, "Antibiotique", "Prendre 1 comprimé 3x/j", LocalDate.now(), LocalDate.now().plusDays(7), p1));
        };
    }

    public static void main(String[] args) {
        SpringApplication.run(GestionPatientsApplication.class, args);
    }
}
