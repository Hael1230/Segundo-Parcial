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

import com.example.demo.entitis.Continente;
import com.example.demo.repository.ContinenteRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/continente")

public class ContinenteController {
    
    @Autowired
	ContinenteRepository continenteRepository;
	
	@GetMapping
	public List<Continente> getContinenteAll() {

		return continenteRepository.findAll();
	}

    @GetMapping("/{id}")
	public Continente getContinentebyId(@PathVariable Integer id) {
		
		Optional<Continente> continente = continenteRepository.findById(id);
		
		if (continente.isPresent()) {
			return continente.get();
		}
		
		return null;

	}

    
}
