package guru.springframework.controllers;

import guru.springframework.commands.PatientForm;
//import guru.springframework.converters.PatientToPatientForm;
import guru.springframework.domain.Patient;
import guru.springframework.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import javax.validation.Valid;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class PatientController {
    private PatientService patientService;

    private PatientToParientForm patientToPatientForm;

    @Autowired
    public void setPatientToPatientForm(PatientToPatientForm patientToPatientForm) {
        this.patientToPatientForm = patientToPatientForm;
    }

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    @RequestMapping("/")
    public String redirToList(){
        return "redirect:/patient/list";
    }

    @RequestMapping({"/patient/list", "/patient"})
    public String listPatient(Model model){
        model.addAttribute("patient", patientService.listAll());
        return "patient/list";
    }

  /*  @RequestMapping("/patient/show/{id}")
    public String getPatient(@PathVariable String id, Model model){
        model.addAttribute("product", patientService.getById(id));
        return "patient/show";
    }

    @RequestMapping("patient/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Patient patient = patientService.getById(id);
        PatientForm patientForm = patientToPatientForm.convert(patient);

        model.addAttribute("patientForm", patientForm);
        return "patient/patientform";
    }

    @RequestMapping("/patient/new")
    public String newPatient(Model model){
        model.addAttribute("patientForm", new PatientForm());
        return "patient/patientform";
    }

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public String saveOrUpdatePatient(@Valid PatientForm patientForm, BindingResult bindingResult){

        if(bindingResult.hasErrors()){
            return "patient/patientform";
        }

        Patient savedPatient = patientService.saveOrUpdateProductForm(productForm);

        return "redirect:/product/show/" + savedProduct.getId();
    }

    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(id);
        return "redirect:/product/list";
    }*/

}
