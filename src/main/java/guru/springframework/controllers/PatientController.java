package guru.springframework.controllers;

import guru.springframework.commands.PatientForm;
//import guru.springframework.converters.PatientToPatientForm;
import guru.springframework.domain.Patient;
import guru.springframework.repositories.PatientRepository;
import guru.springframework.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.ArrayList;
import java.util.List;

import javax.validation.Valid;

import com.fasterxml.jackson.core.sym.Name;

/**
 * Created by jt on 1/10/17.
 */
@Controller
public class PatientController {
    private PatientService patientService;

   /* private PatientToParientForm patientToPatientForm;

    @Autowired
    public void setPatientToPatientForm(PatientToPatientForm patientToPatientForm) {
        this.patientToPatientForm = patientToPatientForm;
    }
    */

    @Autowired
    public void setPatientService(PatientService patientService) {
        this.patientService = patientService;
    }

    /*@RequestMapping("/")
    public String redirToList(){
        return "redirect:/patient/list";
    }*/

    @RequestMapping({"/patient/list", "/patient"})
    public String listPatient(Model model){
        System.out.println("Submit form 1");
        model.addAttribute("patients", patientService.listAll());
        //model.addAttribute("patients", patientService.getByName(name));
        return "patient/list";
    }


    @RequestMapping("/patient/show/{id}")
    public String getPatient(@PathVariable String id, Model model){
        model.addAttribute("patient", patientService.getById(id));
        return "patient/show";
    }

        

/*
    @RequestMapping("patient/edit/{id}")
    public String edit(@PathVariable String id, Model model){
        Patient patient = patientService.getById(id);
        PatientForm patientForm = patientToPatientForm.convert(patient);

        model.addAttribute("patientForm", patientForm);
        return "patient/patientform";
    }*/

    @RequestMapping("/patient/new")
    public String newPatient(Model model){
        System.out.println("1");
        model.addAttribute("patientForm", new PatientForm());
        return "patient/patientform";
    }

    /*@RequestMapping("/patient/search")
    public String newSearch(){
        //model.addAttribute("searchName", new PatientForm());
        return "patient/search";
    }*/

    @RequestMapping(value = "/patient/search")
    public String searchName(){
        System.out.println("Hi search");
        //       Patient savedPatient = patientService.saveOrUpdatePatientForm(patientForm);

        //model.addAttribute("patients", patientService.getByName(name));
        
        /*List<Patient> searched = new ArrayList<>();
        searched = patientService.getByName(name);
        System.out.println(searched);*/


        return "/patient/search";

    }

    @GetMapping(value = "/Search")
    public String search(@RequestParam(value = "Name") String name , Model model){
        System.out.println(name);
        model.addAttribute("patients", patientService.getByName(name));
        System.out.println("8");
        return "/patient/searchlist";
    }
    

    @RequestMapping(value = "/patient", method = RequestMethod.POST)
    public String saveOrUpdatePatient(@Valid PatientForm patientForm, BindingResult bindingResult){
        System.out.println("5");
        if(bindingResult.hasErrors()){
            return "patient/patientform";
        }

        Patient savedPatient = patientService.saveOrUpdatePatientForm(patientForm);

        return "redirect:/patient/show/" + savedPatient.getId();
    }
/*
    @RequestMapping("/product/delete/{id}")
    public String delete(@PathVariable String id){
        productService.delete(id);
        return "redirect:/product/list";
    }*/

}