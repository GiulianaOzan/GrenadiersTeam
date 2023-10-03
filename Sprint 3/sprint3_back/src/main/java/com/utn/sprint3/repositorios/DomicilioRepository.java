package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Domicilio;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DomicilioRepository  extends JpaRepository <Domicilio,Long> {
}
