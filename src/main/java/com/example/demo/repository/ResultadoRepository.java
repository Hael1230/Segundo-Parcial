package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entitis.Resultado;

public interface ResultadoRepository extends JpaRepository<Resultado, Integer>{
    
}
