package ma.enset.hospital.service;

import jakarta.transaction.Transactional;
import ma.enset.hospital.Repository.ConsultationRepository;
import ma.enset.hospital.Repository.MedcinRepository;
import ma.enset.hospital.Repository.PatientRepository;
import ma.enset.hospital.Repository.RendezVousRepository;
import ma.enset.hospital.entities.Consultation;
import ma.enset.hospital.entities.Medcin;
import ma.enset.hospital.entities.Patient;
import ma.enset.hospital.entities.RendezVous;
import org.springframework.stereotype.Service;

@Service
@Transactional
public class HospitalServiceImp implements IHospitalService {

    private PatientRepository patientRepository;
    private MedcinRepository medecinRepository;
    private ConsultationRepository consultationRepository;
    private RendezVousRepository rendezVousRepository;

    public HospitalServiceImp(PatientRepository patientRepository, MedcinRepository medecinRepository, ConsultationRepository consultationRepository, RendezVousRepository rendezVousRepository) {
        this.patientRepository = patientRepository;
        this.medecinRepository = medecinRepository;
        this.consultationRepository = consultationRepository;
        this.rendezVousRepository = rendezVousRepository;
    }


    @Override
    public Patient savePatient(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Medcin saveMedecin(Medcin medecin) {
        return medecinRepository.save(medecin);
    }

    @Override
    public RendezVous saveRendezVous(RendezVous rendezVous) {
        return rendezVousRepository.save(rendezVous);
    }

    @Override
    public Consultation saveConsultation(Consultation consultation) {
        return consultationRepository.save(consultation);
    }
}
