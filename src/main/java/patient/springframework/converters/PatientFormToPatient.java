package patient.springframework.converters;

import patient.springframework.commands.PatientForm;
import patient.springframework.domain.Patient;
import org.bson.types.ObjectId;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import org.springframework.util.StringUtils;


@Component
public class PatientFormToPatient implements Converter<PatientForm, Patient> {

    @Override
    public Patient convert(PatientForm patientForm) {
        Patient patient = new Patient();
        if (patientForm.getId() != null  && !StringUtils.isEmpty(patientForm.getId())) {
            patient.setId(new ObjectId(patientForm.getId()));
        }
        patient.setName(patientForm.getName());
        patient.setAge(patientForm.getAge());
        patient.setGender(patientForm.getGender());
        return patient;
    }
}
