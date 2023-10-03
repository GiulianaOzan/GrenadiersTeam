package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.DetalleFactura;
import org.springframework.data.jpa.repository.JpaRepository;

public interface DetalleFacturaRepository extends JpaRepository <DetalleFactura,Long> {
}
