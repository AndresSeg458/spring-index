package com.andres.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
	@GetMapping("/")
	public String home() {
		//return "redirect:https://www.google.com"; //redirige a la ruta especifica
		return "forward:/app/index"; // realiza und espacho hacia la ruta pero la ruta url en el buscador no cambia
	}
}
