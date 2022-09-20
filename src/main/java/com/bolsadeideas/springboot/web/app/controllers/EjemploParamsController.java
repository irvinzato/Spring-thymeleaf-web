package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")	//"name" es igual al atributo recibido(no es necesario), "required" para evitar error si trae nada y puedo poner valor por defecto
	public String param(@RequestParam(name = "texto", required = false, defaultValue = "Algun valor por defecto") String texto, Model model) {
		model.addAttribute("resultado", "El parametro enviado es: " + texto);
		
		return "params/ver";	//Ruta en templates
	}

}
