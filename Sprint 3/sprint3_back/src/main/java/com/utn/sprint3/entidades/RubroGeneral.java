package com.utn.sprint3.entidades;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;
import lombok.*;

@Entity
@Table(name = "rubro_entidad")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class RubroGeneral extends BaseEntidad{

    private String denominacion;

}
