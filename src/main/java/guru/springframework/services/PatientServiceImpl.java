package guru.springframework.services;

import guru.springframework.commands.PatientForm;
//import guru.springframework.converters.PatientFormToPatient;
import guru.springframework.domain.Patient;
import guru.springframework.repositories.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
@Service
public class PatientServiceImpl implements PatientService {

    private PatientRepository patientRepository;
   // private PatientFormToPatient patientFormToPatient;

   /* @Autowired
    public PatientServiceImpl(PatientRepository patientRepository, PatientFormToPatient patientFormToPatient) {
        this.patientRepository = patientRepository;
        this.patienttFormToPatient = patientFormToPatient;
    }
*/

    @Override
    public List<Patient> listAll() {
        List<Patient> patients = new ArrayList<>();
        patientRepository.findAll().forEach(patients::add); //fun with Java 8
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
/*
    @Override
    public Patient saveOrUpdatePatientForm(PatientForm patientForm) {
        Patient savedPatient = saveOrUpdate(patientFormToPatient.convert(patientForm));

        System.out.println("Saved Patient Id: " + savedPatient.getId());
        return savedPatient;
    }*/

    @Override
    public Patient saveOrUpdateProductForm(PatientForm patientForm) {
        // TODO Auto-generated method stub
        return null;
    }
}
