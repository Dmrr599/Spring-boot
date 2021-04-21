package com.appweb.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.appweb.demo.modelo.Persona;

public interface IpersonaService {
	public List<Persona>listarP();
	public Optional<Persona>listarPId(int dni);
	public int save(Persona p);
	public void delete(int dni);
}
