package com.appweb.demo.servicio;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.appweb.demo.interfaceService.IpersonaService;
import com.appweb.demo.interfaces.IPersona;
import com.appweb.demo.modelo.Persona;

@Service
public class PersonaService implements IpersonaService {

	@Autowired
	private IPersona data;
	
	@Override
	public List<Persona> listarP() {
		// TODO Auto-generated method stub
		return (List<Persona>)data.findAll();
	}

	@Override
	public Optional<Persona> listarPId(int dni) {
		return data.findById(dni);
	}

	@Override
	public int save(Persona p) {
		int res=0;
		Persona persona=data.save(p);
		if(!persona.equals(null)) {
			res=1;
		}
		return res;
	}

	@Override
	public void delete(int dni) {
		data.deleteById(dni);
	}

}
