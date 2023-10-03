package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClienteRepository extends JpaRepository <Cliente,Long> {
}
