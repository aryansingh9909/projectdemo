package patient.springframework.controllers;

import patient.springframework.commands.PatientForm;

import patient.springframework.domain.Patient;

import patient.springframework.services.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;



import javax.validation.Valid;




@Controller
public class PatientController {
    private PatientService patientService;

  

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
        System.out.println("Submit form 1");
        model.addAttribute("patients", patientService.listAll());
        
        return "patient/list";
    }


    @RequestMapping("/patient/show/{id}")
    public String getPatient(@PathVariable String id, Model model){
        model.addAttribute("patient", patientService.getById(id));
        return "patient/show";
    }

        


    @RequestMapping("/patient/new")
    public String newPatient(Model model){
        System.out.println("1");
        model.addAttribute("patientForm", new PatientForm());
        return "patient/patientform";
    }

   

    @RequestMapping(value = "/patient/search")
    public String searchName(){
        System.out.println("Hi search");
       


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


}