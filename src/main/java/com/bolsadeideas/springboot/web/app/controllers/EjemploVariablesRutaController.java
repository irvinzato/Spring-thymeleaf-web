package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/variables")
public class EjemploVariablesRutaController {
	
	@GetMapping("/")
	public String index(Model model) {
		model.addAttribute("atributo", "Lo pase como atributo del model");
		
		return "variables/index";
	}

	@GetMapping("/string/{texto}")	//Importante mismo nombre en "mapping" y "path" de variable
	public String variables(@PathVariable String texto, Model model) {
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto);
		
		return "variables/ver";
	}
	
	//Mas de una variable en la ruta
	@GetMapping("/string/{texto}/{num}")
	public String variables(@PathVariable String texto, @PathVariable Integer num, Model model) {
		model.addAttribute("resultado", "El texto enviado en la ruta es: " + texto + " con el numero: " + num);
		
		return "variables/ver";
	}
	
}
