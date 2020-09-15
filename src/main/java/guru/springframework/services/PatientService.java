package guru.springframework.services;

import guru.springframework.commands.PatientForm;
import guru.springframework.domain.Patient;

import java.util.List;

/**
 * Created by jt on 1/10/17.
 */
public interface PatientService {

    List<Patient> listAll();

    Patient getById(String id);

    Patient saveOrUpdate(Patient patient);

    List<Patient> getByName(String name);

    void delete(String id);

    Patient saveOrUpdatePatientForm(PatientForm patientForm);
}
