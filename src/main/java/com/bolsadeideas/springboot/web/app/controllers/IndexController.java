package com.bolsadeideas.springboot.web.app.controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.bolsadeideas.springboot.web.app.models.Usuario;

@Controller
@RequestMapping("/app") //Añado ruta de primer nivel "http://localhost:8080/app"
public class IndexController {
	
	//Configuracion en "application.properties", con Value inyecto su valor, pero es mejor configurarlos en otro archivo, creé "textos.properties" con su configuración
	@Value("${texto.indexcontroller.index.titulo}")
	private String textIndex;
	
	@Value("${texto.indexcontroller.listar.titulo}")
	private String textList;
	

	//También puedo utilizar @RequestMapping(value="/index") pero @GetMapping es más limpio
	@GetMapping({"/index", "/", "/home"})	//Puedo omitir "value". Si esta asociado a muchas vistas las pongo entre llaves
	public String index(Model model) {
		model.addAttribute("text", "Pase datos a la vista con Model, puedo usar ModelMap, Map, ModelAndView. Otras formas.");
		model.addAttribute("title", textIndex);
		
		return "index";		//Mismo nombre que tiene archivo html en carpeta "template" sin extensión
	}
	
	@RequestMapping("/perfil")
	public String pofile(Model model) {
		Usuario user = new Usuario();
		user.setName("Irving");
		user.setLastName("Rivera");
		user.setEmail("multizato@hotmail.com");
		
		model.addAttribute("title", "Perfil de ".concat(user.getName()));
		model.addAttribute("usuario", user);
		return "perfil";
	}
	
	@RequestMapping("/listar")
	public String toList(Model model) {
		model.addAttribute("title", textList);
	
		return "listar";
	}
	
	@ModelAttribute("listaUsuarios")	//Anotación utilizada para pasar este atributo "listaUsuarios" a TODAS las vistas(metodos)
	public List<Usuario> fillUsers() {
		List<Usuario> usersList = new ArrayList<>();	
		usersList.add(new Usuario("Irving", "Rivera", "multizato@hotmail.com"));
		usersList.add(new Usuario("Jade", "Rivera", "naomiAketza@hotmail.com"));
		usersList.add(new Usuario("Angeles", "Lopez", "angelesLop@hotmail.com"));
		usersList.add(new Usuario("Adan", "Paraiso", "parAdan@hotmail.com"));
		
		return usersList;
	}
	
}
