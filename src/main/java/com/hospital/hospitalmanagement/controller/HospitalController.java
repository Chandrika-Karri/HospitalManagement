package com.hospital.hospitalmanagement.controller;


import com.hospital.hospitalmanagement.domain.Doctor;
import com.hospital.hospitalmanagement.domain.Patient;
import com.hospital.hospitalmanagement.service.DoctorService;
import com.hospital.hospitalmanagement.service.PatientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

//@Controller
//@RequestMapping(value = {"","/hospital"})
//public class HospitalController {
//
//    @Autowired
//    private PatientService patientService;
//
//    @Autowired
//    private DoctorService doctorService;
//
//    @RequestMapping(value = {"/","login"})
//    public String hospital(Model model){
//        //System.out.println(patientService.findAll());
//        //model.addAttribute("persons", patientService.findAll());
//        return "person/login";
//    }
//
//    @RequestMapping(value = "login",method = RequestMethod.POST)
//    public String doctorLogin(Doctor doctor, Model model){
//        System.out.println(doctorService.findByName(doctor.getName()));
//        Doctor doctorLogin=doctorService.findByName(doctor.getName());
//        if(null != doctorLogin && doctor.getPassword().equalsIgnoreCase(doctorLogin.getPassword())){
//            model.addAttribute("patient", patientService.findAll());
//            return "redirect:index";
//        }
//        else{
//            model.addAttribute("errMsg", "Wrong Credentials");
//            return "person/login";
//        }
//
//    }
//
//    @RequestMapping(value = "index")
//    public String index(Model model){
//        System.out.println(patientService.findAll());
//        model.addAttribute("patient", patientService.findAll());
//        return "person/index";
//    }
//
//    @RequestMapping(value = "create")
//    public String create(){
//        return "person/create";
//    }
//
//    @RequestMapping(value = "save", method = RequestMethod.POST)
//    public String save(Patient patient, Model model){
//        patientService.save(patient);
//        model.addAttribute("patient", patientService.findAll());
//        return "person/index";
//    }
//
//    @RequestMapping(value = "edit/{id}")
//    public String edit(@PathVariable Long id, Model model){
//        System.out.println(patientService.findById(id));
//        model.addAttribute("patient", patientService.findById(id));
//        return "person/edit";
//    }
//
//
//    @RequestMapping(value = "update",method = RequestMethod.POST)
//    public String update(Patient patient,Model model){
//        patientService.save(patient);
//        return "redirect:index";
//    }
//
//    @RequestMapping(value = "savedoc",method = RequestMethod.POST)
//    public String saveDoc(Doctor doctor,Model model){
//        doctorService.save(doctor);
//        return "redirect:index";
//    }
//    @RequestMapping(value = "register")
//    public String registerDoc(){
//        return "person/register";
//    }
//
//}

@Controller
@RequestMapping(value = {"", "/hospital"})
public class HospitalController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    // Show login page
    @RequestMapping(value = {"/", "/login"})
    public String hospital(Model model) {
        return "login"; // Thymeleaf template for login
    }

    // Handle doctor login
    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String doctorLogin(Doctor doctor, Model model) {
        System.out.println(doctorService.findByName(doctor.getName()));
        Doctor doctorLogin = doctorService.findByName(doctor.getName());
        if (doctorLogin != null && doctor.getPassword().equalsIgnoreCase(doctorLogin.getPassword())) {
            model.addAttribute("patients", patientService.findAll()); // List of all patients
            return "redirect:/hospital/index"; // Redirect to the index page
        } else {
            model.addAttribute("errMsg", "Wrong Credentials"); // Error message for wrong login
            return "login"; // Return to login page
        }
    }

    // Show index page with all patients
    @RequestMapping(value = "index")
    public String index(Model model) {
        System.out.println(patientService.findAll());
        model.addAttribute("patients", patientService.findAll()); // List of all patients
        return "index"; // Thymeleaf template for the index page
    }

    // Show create patient page
    @RequestMapping(value = "create")
    public String create() {
        return "create"; // Thymeleaf template for creating a new patient
    }

    // Save a new patient
    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Patient patient, Model model) {
        patientService.save(patient);
        model.addAttribute("patients", patientService.findAll()); // Add all patients to model
        return "index"; // Return to the index page after saving
    }

    // Show edit page for a patient
    @RequestMapping(value = "edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        System.out.println(patientService.findById(id));
        model.addAttribute("patient", patientService.findById(id)); // Add patient to model for editing
        return "edit"; // Thymeleaf template for editing a patient
    }

    // Update patient details
    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Patient patient, Model model) {
        patientService.save(patient); // Save the updated patient
        return "redirect:/hospital/index"; // Redirect to index page after update
    }

    // Save a new doctor
    @RequestMapping(value = "savedoc", method = RequestMethod.POST)
    public String saveDoc(Doctor doctor, Model model) {
        doctorService.save(doctor);
        return "redirect:/hospital/index"; // Redirect to index page after saving doctor
    }

    // Show doctor registration page
    @RequestMapping(value = "register")
    public String registerDoc() {
        return "register"; // Thymeleaf template for doctor registration
    }

}


