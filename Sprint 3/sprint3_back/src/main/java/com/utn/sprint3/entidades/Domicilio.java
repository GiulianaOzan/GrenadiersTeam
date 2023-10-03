package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "domicilio")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Domicilio extends BaseEntidad{

    @NotNull
    @Column(length = 500)
    private String calle;

    @NotNull
    @Column(precision = 5)
    private int numero;

    @NotNull
    @Column(precision = 4)
    private int codigoPostal;

    @NotNull
    private String localidad;

    @Column(name = "numero_vivienda")
    private int numeroDpto;

    @Column(name = "piso_vivienda")
    private int pisoDpto;

   /* @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private Cliente cliente; NO IRIA POR QUE CAMBIA LA NAVEGABILIDAD*/

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaBaja;

}
