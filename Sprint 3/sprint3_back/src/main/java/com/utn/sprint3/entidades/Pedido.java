package com.utn.sprint3.entidades;

import com.utn.sprint3.enums.EstadoPedido;
import com.utn.sprint3.enums.FormaPago;
import com.utn.sprint3.enums.TipoEnvio;
import jakarta.persistence.*;
import lombok.*;
import org.antlr.v4.runtime.misc.NotNull;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "pedido")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Data
@Builder
public class Pedido extends BaseEntidad{

    @NotNull
    @Column(name = "fecha_pedido")
    @Temporal(TemporalType.DATE)
    private Date fechaPedido;

    @NotNull
    @Column(name = "hora_estimada_finalizacion")
    @Temporal(TemporalType.TIMESTAMP)
    private Date horaEstimadaFinalizacion;

    @NotNull
    @Column(name = "total")
    private double total;

    @NotNull
    @Column(name = "total_costo")
    private double totalCosto;

    @NotNull
    @Enumerated(EnumType.STRING)
    private EstadoPedido estado;

    @NotNull
    @Column(name = "tipo_envio")
    @Enumerated(EnumType.STRING)
    private TipoEnvio tipoEnvio;

    @NotNull
    @Column(name = "forma_pago")
    @Enumerated(EnumType.STRING)
    private FormaPago formaPago;

    @NotNull
    @ManyToOne()
    @JoinColumn(name = "id_cliente")
    private Cliente cliente;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true,fetch = FetchType.EAGER)
    @JoinColumn(name = "id_pedido")
    @Builder.Default
    private List<DetallePedido> detallePedidos = new ArrayList<>();

    @ManyToOne()
    @JoinColumn(name = "id_domicilio")
    private Domicilio domicilio;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "id_factura")
    private Factura factura;

    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "id_mercado_pago_datos")
    private MercadoPagoDatos mercadoPagoDatos;

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


    public void agregarDetallePedido(DetallePedido detallePedido){

        detallePedidos.add(detallePedido);
    }
}
