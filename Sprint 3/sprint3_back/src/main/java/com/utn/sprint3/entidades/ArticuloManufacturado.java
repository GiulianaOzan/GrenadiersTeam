package com.utn.sprint3.entidades;

import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "articulo_manufacturado")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@Data
@Builder
public class ArticuloManufacturado extends BaseEntidad{

    @NotNull
    private String denominacion;

    @NotNull
    @Column(length = 1000)
    private String descripcion;

    @NotNull
    @Column(name = "tiempo_estimado_cocina")
    private int tiempoEstimadoCocina;

    @NotNull
    @Column(name = "precio_venta")
    private double precioVenta;

    @Column(name = "costo")
    private double costo;

    @Column(length = 500, name = "url_imagen")
    private String urlImagen;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_rubro_general")
    private RubroGeneral rubroGeneral;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_articulo_manufacturado")
    @Builder.Default
    private List<DetalleArticuloManufacturado> detalleArticuloManufacturados = new ArrayList<>();

    @NotNull
    @Column(name = "fecha_alta")
    @Temporal(TemporalType.DATE)
    private Date fechaAlta;

    @Column(name = "fecha_modificacion")
    @Temporal(TemporalType.DATE)
    private Date fechaModificacion;

    @Column(name = "fecha_baja")
    @Temporal(TemporalType.DATE)
    private Date fechaBaja;

    public void agregarDetalleArticuloManufacturado(DetalleArticuloManufacturado detalleArticuloManufacturado){

        detalleArticuloManufacturados.add(detalleArticuloManufacturado);
    }


}
