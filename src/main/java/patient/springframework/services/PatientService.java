package patient.springframework.services;

import patient.springframework.commands.PatientForm;
import patient.springframework.domain.Patient;

import java.util.List;


public interface PatientService {

    List<Patient> listAll();

    Patient getById(String id);

    Patient saveOrUpdate(Patient patient);

    List<Patient> getByName(String Name);

    void delete(String id);

    Patient saveOrUpdatePatientForm(PatientForm patientForm);
}
