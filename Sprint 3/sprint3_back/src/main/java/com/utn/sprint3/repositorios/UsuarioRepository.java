package com.utn.sprint3.repositorios;

import com.utn.sprint3.entidades.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UsuarioRepository extends JpaRepository <Usuario,Long> {
}
