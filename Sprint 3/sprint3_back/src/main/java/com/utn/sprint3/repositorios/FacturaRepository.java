package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Factura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FacturaRepository extends JpaRepository <Factura,Long> {
}
