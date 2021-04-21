package com.appweb.demo.interfaceService;

import java.util.List;
import java.util.Optional;

import com.appweb.demo.modelo.Domicilio;

public interface IdomicilioService {
	public List<Domicilio>listarD();
	public Optional<Domicilio>listarDId(int id);
	public int guardar(Domicilio d);
	public void borrar(int id);
}
