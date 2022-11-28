package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entitis.Estadio;
import com.example.demo.repository.EstadioRepository;

import java.util.List;
import java.util.Optional;

public class EstadioController {

    @Autowired
	EstadioRepository estadioRepository;
	
	@GetMapping
	public List<Estadio> getEstadioAll() {

		return estadioRepository.findAll();
	}

    @GetMapping("/{id}")
	public Estadio getEstadiobyId(@PathVariable Integer id) {
		
		Optional<Estadio> estadio = estadioRepository.findById(id);
		
		if (estadio.isPresent()) {
			return estadio.get();
		}
		
		return null;

	}

    @DeleteMapping("/{id}")
	public Estadio deleteEstadiosbyId(@PathVariable Integer id) {
		
		Optional<Estadio> estadio = estadioRepository.findById(id);
		
		if (estadio.isPresent()) {
			
			final Estadio estadioReturn = estadio.get();
			
			estadioRepository.deleteById(id);
			
			return estadioReturn;
		}
		
		return null;

	}
    
}
