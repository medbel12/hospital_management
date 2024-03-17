package ma.enset.hospital;

import ma.enset.hospital.Repository.ConsultationRepository;
import ma.enset.hospital.Repository.MedcinRepository;
import ma.enset.hospital.Repository.PatientRepository;
import ma.enset.hospital.Repository.RendezVousRepository;
import ma.enset.hospital.entities.*;
import ma.enset.hospital.service.IHospitalService;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.stream.Stream;

@SpringBootApplication
public class HospitalApplication {

    public static void main(String[] args) {
        SpringApplication.run(HospitalApplication.class, args);
    }

    @Bean
    CommandLineRunner start(IHospitalService hospitalService,
                            PatientRepository patientRepository, MedcinRepository medecinRepository, RendezVousRepository rendezVousRepository, ConsultationRepository consultationRepository) {
        return args -> {
            Stream.of("mohamed", "anouar", "ibrahim", "salah").forEach(nom -> {
                Patient p1 = new Patient();
                p1.setNom(nom);
                p1.setDateNaissance(new Date());
                p1.setMalade(false);
                hospitalService.savePatient(p1);
            });

            Stream.of("abdelkader", "bahaka", "charki").forEach(nom -> {
                Medcin m1 = new Medcin();
                m1.setNom(nom);
                m1.setEmail(nom+"@gmail.com");
                m1.setSpecialite(Math.random() > 0.5 ? "Dentiste" : "cardio");
                hospitalService.saveMedecin(m1);
            });


            Patient p1 = patientRepository.findById(3L).orElse(null);
            Patient p2 = patientRepository.findByNom("ibrahim");

            Medcin m1 = medecinRepository.findById(1L).orElse(null);
            Medcin m2 = medecinRepository.findByNom("bahaka");

            RendezVous rdv1 = new RendezVous();
            rdv1.setDate(new Date());
            rdv1.setPatient(p1);
            rdv1.setMedecin(m1);
            rdv1.setStatus(StatusRdv.CANCELED);
            hospitalService.saveRendezVous(rdv1);

            Consultation c1 = new Consultation();
            c1.setDateConsultation(new Date());
            c1.setRapport("Rapport 1");
            c1.setRendezVous(rdv1);
            hospitalService.saveConsultation(c1);
        };

    }
}
