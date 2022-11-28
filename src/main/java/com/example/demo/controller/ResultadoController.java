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

import com.example.demo.entitis.Resultado;
import com.example.demo.entitis.Partido;
import com.example.demo.repository.ResultadoRepository;

import java.util.List;
import java.util.Optional;

public class ResultadoController {
    
    @Autowired
	ResultadoRepository resultadoRepository;
	
	@GetMapping
	public List<Resultado> getResultadoAll() {

		return resultadoRepository.findAll();
	}

    @GetMapping("/{id}")
	public Resultado getResultadobyId(@PathVariable Integer id) {
		
		Optional<Resultado> resultado = resultadoRepository.findById(id);
		
		if (resultado.isPresent()) {
			return resultado.get();
		}
		
		return null;

	}

    @PutMapping("/{id}")
	public Resultado putResultadosbyId(@PathVariable Integer id, @RequestBody Resultado resultado) {
		
		Optional<Resultado> resultadoCurrent = resultadoRepository.findById(id);
		
		if (resultadoCurrent.isPresent()) {
			
			Resultado resultadoReturn = resultadoCurrent.get();
			
			
			resultadoReturn.setGoles(resultado.getGoles());
			
			
			
			resultadoRepository.save(resultadoReturn);
			
			return resultadoReturn;
		}
		
		return null;

	}

    @PostMapping
	public Resultado postResultado(@RequestBody Resultado resultado) {
		
		resultadoRepository.save(resultado);
		
		return resultado;
		

	}
}
