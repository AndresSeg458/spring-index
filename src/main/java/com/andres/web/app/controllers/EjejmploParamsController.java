package com.andres.web.app.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/params")
public class EjejmploParamsController {
	
	@GetMapping("/")
	public String index() {
	
		return "params/index";
	}
	
	@GetMapping("/string")
	public String param(@RequestParam(name="texto", required = false, defaultValue = "Valor por defecto") String texto, Model model) {
		model.addAttribute("resultado", "El parametro enviado es: " + texto);
		return"params/ver";
	}
	
	@GetMapping("/mix")
	public String param(@RequestParam String saludo,@RequestParam Integer numero, Model model) {
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo +"' y el número es: '"+ numero+"'");
		return"params/ver";
	}
	
	@GetMapping("/mix-request")
	public String param(HttpServletRequest reque, Model model) {
		String saludo = reque.getParameter("saludo");
		Integer numero = null;
		try {
			numero = Integer.parseInt( reque.getParameter("numero"));
		} catch (NumberFormatException e) {
			numero = 0;
		}
		
		model.addAttribute("resultado", "El saludo enviado es: '" + saludo +"' y el número es: '"+ numero+"'");
		return"params/ver";
	}
}
