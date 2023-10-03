package com.utn.sprint3.entidades;

import com.utn.sprint3.enums.FormaPago;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.util.Date;

@Entity
@Table(name = "mercadoPagoDatos")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class MercadoPagoDatos extends BaseEntidad{

    private String estado;

    private String formaPago;

    private int identificadorPago;

    private String metodoPago;

    private String nroTarjeta;

    @NotNull
    @Column(name = "fecha_aprobacion")
    @Temporal(TemporalType.DATE)
    private Date fechaAprobacion;

    @Column(name = "fecha_creacion")
    @Temporal(TemporalType.DATE)
    private Date fechaCreacion;


}
