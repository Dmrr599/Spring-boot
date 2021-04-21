package com.appweb.demo.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.appweb.demo.modelo.Domicilio;

@Repository
public interface IDomicilio extends CrudRepository<Domicilio, Integer> {

}
