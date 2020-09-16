package patient.springframework.services;

import patient.springframework.commands.PatientForm;
import patient.springframework.converters.PatientFormToPatient;
import patient.springframework.domain.Patient;
import patient.springframework.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
    private PatientFormToPatient patientFormToPatient;

    @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, PatientFormToPatient patientFormToPatient) {
       
        this.patientRepository = patientRepository;
        this.patientFormToPatient = patientFormToPatient;
    }

    @Override
    public List<Patient> listAll() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add); 
        return patients;
    }

    @Override
    public Patient getById(String id) {
        return patientRepository.findById(id).orElse(null);
    }

    @Override
    public Patient saveOrUpdate(Patient patient) {
        patientRepository.save(patient);
        return patient;
    }

    @Override
    public void delete(String id) {
        patientRepository.deleteById(id);
    }

    @Override
    public Patient saveOrUpdatePatientForm(PatientForm patientForm) {
        Patient savedPatient = saveOrUpdate(patientFormToPatient.convert(patientForm));

        System.out.println("Saved Patient Id: " + savedPatient.getId());
        return savedPatient;
    }

    @Override
    public List<Patient> getByName(String Name) {
        List<Patient> patients = new ArrayList<>();
        patientRepository.getByName(Name).forEach(patients::add); 
        return patients;
    }

      
}
