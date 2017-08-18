package com.jasonswitzer.driverslicense.controllers;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.jasonswitzer.driverslicense.models.License;
import com.jasonswitzer.driverslicense.models.Person;
import com.jasonswitzer.driverslicense.services.LicenseService;
import com.jasonswitzer.driverslicense.services.PersonService;

@Controller
@RequestMapping("/")
public class DriversLicense {
	
	private final PersonService personService;
	private final LicenseService licenseService;
	
	public DriversLicense(PersonService personService, LicenseService licenseService) {
		this.personService = personService;
		this.licenseService = licenseService;
	}
	
	@GetMapping("persons/new")
	public String newPerson(@ModelAttribute("person") Person person, Model model) {
		return "newperson.jsp";
	}
	
	@PostMapping("persons/new")
	public String createPerson(
			@Valid
			@ModelAttribute("person") Person person,
			BindingResult result,
			Model model) {
		if (result.hasErrors()) {
			return "newperson.jsp";
		} else {
			personService.addPerson(person);
			return "redirect:/persons/new";
		}
	}	
	
	@GetMapping("licenses/new")
	public String newLicense(@ModelAttribute("license") License license, Model model) {
		model.addAttribute("persons", personService.getAllPersons());
		return "newlicense.jsp";
	}
	
	@PostMapping("licenses/new")
	public String createLicense(
			@RequestParam(value="person") Long id,
			@Valid 
			@ModelAttribute("license") License license,
			BindingResult result,
			Model model) {
		model.addAttribute("persons", personService.getAllPersons());
		if (result.hasErrors()) {
			return "newlicense.jsp";
		} else if (personService.findPersonById(id).getLicense() != null) {
			return "newlicense.jsp";
		} else {
			licenseService.addLicense(license);
			return "redirect:/persons/" + id;
		}
}
	
	@GetMapping("persons/{id}")
	public String details(@PathVariable("id") Long id, Model model) {
		model.addAttribute("person", personService.findPersonById(id));
		return "showperson.jsp";
	}
}
