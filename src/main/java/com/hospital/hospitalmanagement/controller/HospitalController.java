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

@Controller
@RequestMapping(value = {"", "/hospital"})
public class HospitalController {

    @Autowired
    private PatientService patientService;

    @Autowired
    private DoctorService doctorService;

    @RequestMapping(value = {"/", "/login"})
    public String hospital(Model model) {
        return "login";
    }

    @RequestMapping(value = "login", method = RequestMethod.POST)
    public String doctorLogin(Doctor doctor, Model model) {
        System.out.println(doctorService.findByName(doctor.getName()));
        Doctor doctorLogin = doctorService.findByName(doctor.getName());
        if (doctorLogin != null && doctor.getPassword().equalsIgnoreCase(doctorLogin.getPassword())) {
            model.addAttribute("patients", patientService.findAll());
            return "redirect:/hospital/index";
        } else {
            model.addAttribute("errMsg", "Wrong Credentials");
            return "login";
        }
    }

    @RequestMapping(value = "index")
    public String index(Model model) {
        System.out.println(patientService.findAll());
        model.addAttribute("patients", patientService.findAll());
        return "index";
    }

    @RequestMapping(value = "create")
    public String create() {
        return "create";
    }

    @RequestMapping(value = "save", method = RequestMethod.POST)
    public String save(Patient patient, Model model) {
        patientService.save(patient);
        model.addAttribute("patients", patientService.findAll());
        return "index";
    }

    @RequestMapping(value = "edit/{id}")
    public String edit(@PathVariable Long id, Model model) {
        System.out.println(patientService.findById(id));
        model.addAttribute("patient", patientService.findById(id));
        return "edit";
    }

    @RequestMapping(value = "update", method = RequestMethod.POST)
    public String update(Patient patient, Model model) {
        patientService.save(patient);
        return "redirect:/hospital/index";
    }

    @RequestMapping(value = "savedoc", method = RequestMethod.POST)
    public String saveDoc(Doctor doctor, Model model) {
        doctorService.save(doctor);
        return "redirect:/hospital/index";
    }

    @RequestMapping(value = "register")
    public String registerDoc() {
        return "register";
    }

}


