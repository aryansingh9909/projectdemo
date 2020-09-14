package guru.springframework.repositories;

import guru.springframework.domain.Patient;
import org.springframework.data.repository.CrudRepository;

/**
 * Created by jt on 1/10/17.
 */
public interface PatientRepository extends CrudRepository<Patient, String> {
}
