package com.bolsadeideas.springboot.web.app.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping("/params")
public class EjemploParamsController {
	
	//Son métodos handle cada uno de ellos
	
	@GetMapping("/")
	public String index() {
		return "params/index";
	}
	
	@GetMapping("/string")	//"name" es igual al atributo recibido(no es necesario), "required" para evitar error si trae nada y puedo poner valor por defecto
	public String param(@RequestParam(name = "texto", required = false, defaultValue = "Algun valor por defecto") String texto, Model model) {
		model.addAttribute("resultado", "El parametro enviado es: " + texto);
		
		return "params/ver";	//Ruta en templates
	}
	
	//Envio más de un parámetro
	@GetMapping("/mix-params")	
	public String mixParam(@RequestParam String saludo, @RequestParam Integer num, Model model) {
		model.addAttribute("resultado", "El parametro enviado es: " + saludo + " el numero es: " + num);
		
		return "params/ver";
	}
	
	//Otra forma pero sin anotaciones(menos elegante y moderno)
	@GetMapping("/mix-params-request")	
	public String mixParam(HttpServletRequest request, Model model) {
		String saludo = request.getParameter("saludo");
		Integer num = null;
		try {
			num = Integer.parseInt(request.getParameter("num"));
		}catch(NumberFormatException e) {
			num = 0;
		}
		model.addAttribute("resultado", "El parametro enviado es: " + saludo + " el numero es: " + num);
		
		return "params/ver";
	}

}
