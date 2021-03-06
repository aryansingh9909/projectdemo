package patient.springframework.repositories;

import patient.springframework.domain.Patient;

import java.util.List;


import org.springframework.data.repository.CrudRepository;


public interface PatientRepository extends CrudRepository<Patient, String>{

    List<Patient> getByName(String Name);
}
