package com.bolsadeideas.springboot.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app") //Añado ruta de primer nivel "http://localhost:8080/app"
public class IndexController {

	//También puedo utilizar @RequestMapping(value="/index") pero dejo @GetMapping porque es más limpio
	@GetMapping({"/index", "/", "/home"})	//Puedo omitir "value". Si esta asociado a muchas vistas las pongo entre llaves
	public String index(Model model) {
		model.addAttribute("title", "Pase datos a la vista con Model, puedo usar ModelMap, Map, ModelAndView. Otras formas.");
		return "index";		//Mismo nombre que tiene archivo html en carpeta "template" sin extensión
	}
	
	@RequestMapping("/perfil")
	public String pofile(Model model) {
		Usuario user = new Usuario();
		user.setName("Irving");
		user.setLastName("Rivera");
		
		model.addAttribute("title", "Perfil de ".concat(user.getName()));
		model.addAttribute("usuario", user);
		return "perfil";
	}
	
	
	
}
