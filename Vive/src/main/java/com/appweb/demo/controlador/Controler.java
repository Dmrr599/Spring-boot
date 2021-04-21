package com.appweb.demo.controlador;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.appweb.demo.interfaceService.IdomicilioService;
import com.appweb.demo.interfaceService.IpersonaService;
import com.appweb.demo.modelo.Domicilio;
import com.appweb.demo.modelo.Persona;

@Controller
@RequestMapping
public class Controler {
	
	@Autowired
	private IpersonaService service;
	
	@Autowired
	private IdomicilioService serviceD;

	@GetMapping("/listar")
	public String listar(Model model) {
		List<Persona>personas = service.listarP();
		model.addAttribute("personas", personas);
		
		List<Domicilio>domicilios = serviceD.listarD();
		model.addAttribute("domicilios", domicilios);
		
		return "index";
	}
	
	@GetMapping("/newP")
	public String agregarP(Model model) {
		model.addAttribute("persona", new Persona());
		return "formP";
	}
	
	@GetMapping("/newD")
	public String agregarD(Model model) {
		model.addAttribute("domicilio", new Domicilio());
		return "formD";
	}
	
	@PostMapping("/save")
	public String save(@Valid Persona p, Model model) {
		service.save(p);
		return "redirect:/listar";
	}
	
	@PostMapping("/guardar")
	public String guardar(@Valid Domicilio d, Model model) {
		serviceD.guardar(d);
		return "redirect:/listar";
	}
	
	@GetMapping("/editarP/{dni}")
	public String editarP(@PathVariable int dni, Model model) {
		Optional<Persona>persona=service.listarPId(dni);
		model.addAttribute("persona",persona);
		return "formP";
	}
	
	@GetMapping("/editarD/{id}")
	public String editarD(@PathVariable int id, Model model) {
		Optional<Domicilio>domicilio=serviceD.listarDId(id);
		model.addAttribute("domicilio",domicilio);
		return "formD";
	}
	
	@GetMapping("/eliminarP/{dni}")
	public String delete(@PathVariable int dni, Model model) {
		service.delete(dni);
		return "redirect:/listar";
	}
	
	@GetMapping("/eliminarD/{id}")
	public String borrar(@PathVariable int id, Model model) {
		serviceD.borrar(id);
		return "redirect:/listar";
	}
	

}
