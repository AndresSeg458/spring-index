package com.andres.web.app.controllers;

import java.util.Arrays;
import java.util.List;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.andres.web.app.models.usuario;

@Controller
@RequestMapping("/app")
public class IndexController {
	
	// estos value estan en properties 
	
	@Value(value = "${texto.indexcontroller.index.titulo}")
	private String  textIndex;
	@Value(value = "${texto.indexcontroller.perfil.titulo}")
	private String  textPerfil;
	@Value(value = "${texto.indexcontroller.listar.titulo}")
	private String  textListar;
	
	
	@GetMapping({"/index","/","/home"})
	public String index(Model model) {
		model.addAttribute("titulo",textIndex);
		return "index"; // abre templates/index 
	}
	
	
	@GetMapping("/perfil")
	public String perfil(Model model) {
		usuario user = new usuario();
		user.setNombre("Andrés");
		user.setApellido("Segovia");
		user.setEmail("andres@correo.gov.co");
		
		model.addAttribute("usuario", user);
		model.addAttribute("titulo",textPerfil.concat(user.getNombre()));
		
		return"perfil";
	}
	
	
	@GetMapping("/listar")
	public String listar(Model model) {
		model.addAttribute("titulo",textListar);
		return "listar";
	}
	
	@ModelAttribute("usuarios")
	public List<usuario> llenarUsuarios(){
		List<usuario> usuarios = Arrays.asList(
				new usuario("Andrés","Segovia","asegovia@gm.com"),
				new usuario("Nata","Florez","nflorez@gm.com"),
				new usuario("Juan","Calderon","jcalderon@gm.com"),
				new usuario("Camila","Villalba","cvillalba@gm.com"));
		return usuarios;
	}
	
	
	
}
