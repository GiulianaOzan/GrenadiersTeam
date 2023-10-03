package com.utn.sprint3.entidades;

import com.utn.sprint3.enums.FormaPago;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "factura")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Factura extends BaseEntidad{

    @NotNull
    @Column(name = "fecha_facturacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date fechaFacturacion;

    @Column(name = "mp_payment_id")
    private int mpPaymentId;

    @Column(name = "mp_merchant_order_id")
    private int mpMerchantOrderId;

    @Column(name = "mp_preference_id")
    private String mpPreferenceId;

    @Column(name = "mp_payment_type")
    private String mpPaymentType;

    @NotNull
    private FormaPago formaPago;

    @NotNull
    @Column(name = "total_venta")
    private double totalVenta;

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

    /*@NotNull
    @OneToOne
    @JoinColumn(name = "id_pedido")
    private Pedido pedido; CAMBIA LA NAVEGABILIDAD*/

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_factura")
    @Builder.Default
    private List<DetalleFactura> detalleFacturas = new ArrayList<>();

    public void agregarDetalleFactura(DetalleFactura detalleFactura){

        detalleFacturas.add(detalleFactura);
    }

}
