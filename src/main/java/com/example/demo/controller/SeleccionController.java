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

import com.example.demo.entitis.Seleccion;
import com.example.demo.entitis.Continente;
import com.example.demo.repository.SeleccionRepository;

import java.util.List;
import java.util.Optional;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/seleccion")

public class SeleccionController {
    @Autowired
	SeleccionRepository seleccionRepository;
	
	@GetMapping
	public List<Seleccion> getSeleccionAll() {

		return seleccionRepository.findAll();
	}

    @GetMapping("/{id}")
	public Seleccion getSeleccionbyId(@PathVariable Integer id) {
		
		Optional<Seleccion> seleccion = seleccionRepository.findById(id);
		
		if (seleccion.isPresent()) {
			return seleccion.get();
		}
		
		return null;

	}

    @PostMapping
	public Seleccion postSeleccion(@RequestBody Seleccion seleccion) {
		
		seleccionRepository.save(seleccion);
		
		return seleccion;
		

	}

    @GetMapping("/{nombre}/continente")
	public Continente getContinenteNombre(@PathVariable String nombre) {
		
		List<Seleccion> seleccion = seleccionRepository.findByNombre(nombre);
		
		if (!Seleccion.isEmpty()) {
			return seleccion.get(0).getContinente();
		}
		
		return null;

	}

	@GetMapping("/{grupo}")
	public Seleccion getSeleccionbyGrupo(@PathVariable String grupo) {
		
		Optional<Seleccion> seleccion = seleccionRepository.findByGrupo(grupo);
		
		if (seleccion.isPresent()) {
			return seleccion.get();
		}
		
		return null;

	}
}
