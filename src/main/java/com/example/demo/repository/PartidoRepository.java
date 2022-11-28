package com.example.demo.repository;

import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import com.example.demo.entitis.Partido;

public interface PartidoRepository extends JpaRepository<Partido, Integer> {
    
}
