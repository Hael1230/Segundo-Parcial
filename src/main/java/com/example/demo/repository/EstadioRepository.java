package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entitis.Continente;
import com.example.demo.entitis.Estadio;

public interface EstadioRepository extends JpaRepository<Estadio, Integer>{
    
}
