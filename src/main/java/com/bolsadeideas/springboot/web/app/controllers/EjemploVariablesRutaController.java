package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {

	@GetMapping("/string/{texto}")	//Importante mismo nombre en "mapping" y "path" de variable
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);
		
		return "variables/ver";
	}
	
}
