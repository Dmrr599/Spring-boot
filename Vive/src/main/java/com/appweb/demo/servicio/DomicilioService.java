package com.appweb.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appweb.demo.interfaceService.IdomicilioService;
import com.appweb.demo.interfaces.IDomicilio;
import com.appweb.demo.modelo.Domicilio;

@Service
public class DomicilioService implements IdomicilioService {

	@Autowired
	private IDomicilio dato;
	
	@Override
	public List<Domicilio> listarD() {
		return (List<Domicilio>)dato.findAll();
	}

	@Override
	public Optional<Domicilio> listarDId(int id) {
		return dato.findById(id);
	}

	@Override
	public int guardar(Domicilio d) {
		int resD=0;
		Domicilio domicilio=dato.save(d);
		if(!domicilio.equals(null)) {
			resD=1;
		}
		return resD;
	}

	@Override
	public void borrar(int id) {
		dato.deleteById(id);
		
	}

}
