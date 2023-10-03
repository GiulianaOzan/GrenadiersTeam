package com.utn.sprint3;

import com.utn.sprint3.entidades.*;
import com.utn.sprint3.enums.EstadoPedido;
import com.utn.sprint3.enums.FormaPago;
import com.utn.sprint3.enums.Rol;
import com.utn.sprint3.enums.TipoEnvio;
import com.utn.sprint3.repositorios.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import java.text.SimpleDateFormat;
import java.util.Date;

@SpringBootApplication
public class Sprint3Application {

	@Autowired
	RubroArticuloRepository rubroArticuloRepository;
	@Autowired
	ClienteRepository clienteRepository;
	@Autowired
	ArticuloManufacturadoRepository articuloManufacturadoRepository;
	@Autowired
	ArticuloInsumoRepository articuloInsumoRepository;
	@Autowired
	DetalleArticuloManufacturadoRepository detalleArticuloManufacturadoRepository;
	@Autowired
	DetalleFacturaRepository detalleFacturaRepository;
	@Autowired
	DetallePedidoRepository detallePedidoRepository;
	@Autowired
	DomicilioRepository domicilioRepository;
	@Autowired
	FacturaRepository facturaRepository;
	@Autowired
	MercadoPagoDatosRepository mercadoPagoDatosRepository;
	@Autowired
	PedidoRepository pedidoRepository;
	@Autowired
	RubroGeneralRepository rubroGeneralRepository;
	@Autowired
	UnidadMedidaRepository unidadMedidaRepository;
	@Autowired
	UsuarioRepository usuarioRepository;

	public static void main(String[] args) {

		SpringApplication.run(Sprint3Application.class, args);
		System.out.println("Estoy funcionando");
	}


	@Bean
	CommandLineRunner init(RubroArticuloRepository rubroArticuloRepository1) {
		return args -> {
			System.out.println("ESTOY----FUNCIONANDO");

			//configuracion fecha
			SimpleDateFormat formatoFecha = new SimpleDateFormat ("yyyy-MM-dd");
			String fechaString = "2023-09-09";
			// Parsear la cadena en un objeto Date
			Date fecha = formatoFecha.parse(fechaString);

			//CREAR INSTANCIA DE RUBRO ----------------------------------------------------

			RubroArticulo rubro0 = RubroArticulo.builder()
					.denominacion("Insumos")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			RubroArticulo rubro1 = RubroArticulo.builder()
					.denominacion("Insumos hijos")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.rubroPadre(rubro0)
					.build();

			RubroArticulo rubro2 = RubroArticulo.builder()
					.denominacion("Insumos hijos hijos")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.rubroPadre(rubro0)
					.build();

			rubroArticuloRepository.save(rubro0);
			rubroArticuloRepository.save(rubro1);
			rubroArticuloRepository.save(rubro2);

			//CREAR UNIDAD DE MEDIDA -------------------------------------------------------

			UnidadMedida unidadMedida1 = UnidadMedida.builder()
					.abreviatura("Kg")
					.denominacion("Insumos")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			UnidadMedida unidadMedida2 = UnidadMedida.builder()
					.abreviatura("cm3")
					.denominacion("Insumos")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			unidadMedidaRepository.save(unidadMedida1);
			unidadMedidaRepository.save(unidadMedida2);


			// CREAR INSTANCIA DE ARTICULO INSUMO ------------------------------------------

			ArticuloInsumo articuloInsumo1 = ArticuloInsumo.builder()
					.denominacion("Harina 000")
					.precioCompra(500)
					.stockMinimo(8)
					.stockActual(15)
					.urlImagen("Harina.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();
			ArticuloInsumo articuloInsumo2 = ArticuloInsumo.builder()
					.denominacion("Queso cheddar")
					.precioCompra(300)
					.stockMinimo(5)
					.stockActual(50)
					.urlImagen("Cheddar.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();



			//Vinculamos el rubro a los articulos ------------------------------------------

			articuloInsumo1.setRubroArticulo(rubro0);
			articuloInsumo2.setRubroArticulo(rubro0);

			articuloInsumoRepository.save(articuloInsumo1);
			articuloInsumoRepository.save(articuloInsumo2);

			// Vinculamos la unidad medida al articulo -------------------------------------

			articuloInsumo1.setUnidadMedida(unidadMedida1);
			articuloInsumo2.setUnidadMedida(unidadMedida2);
			articuloInsumoRepository.save(articuloInsumo1);
			articuloInsumoRepository.save(articuloInsumo2);


			//	CREAR INSTANCIA RUBRO GRAL -------------------------------------------------

			RubroGeneral rubroGeneral1 = RubroGeneral.builder()
					.denominacion("Manufacturados")
					.build();
			RubroGeneral rubroGeneral2 = RubroGeneral.builder()
					.denominacion("Insumos")
					.build();

			rubroGeneralRepository.save(rubroGeneral1);
			rubroGeneralRepository.save(rubroGeneral2);

			//CREAR DETALLE ART MANUFACTURADO ----------------------------------------------

			DetalleArticuloManufacturado detalleArticuloManufacturado1 = DetalleArticuloManufacturado.builder()
					.cantidad(5)
					.build();

			DetalleArticuloManufacturado detalleArticuloManufacturado2 = DetalleArticuloManufacturado.builder()
					.cantidad(15)
					.build();

			/*detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado1);
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado2);*/

			//CREAR INSTANCIA DE ART MANUFACTU ---------------------------------------------

			ArticuloManufacturado articuloManufacturado1 = ArticuloManufacturado.builder()
					.costo(700)
					.denominacion("Prepizza oregano")
					.descripcion("precalentada")
					.precioVenta(600)
					.tiempoEstimadoCocina(15)
					.urlImagen("Prepiza.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			ArticuloManufacturado articuloManufacturado2 = ArticuloManufacturado.builder()
					.costo(900)
					.denominacion("Pan de papa")
					.descripcion("sin levadura")
					.precioVenta(400)
					.tiempoEstimadoCocina(15)
					.urlImagen("Panpapa.jpg")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();


			//VINCULAR DETALLE ART MANU A ART MANUF ---------------------------------------

			articuloManufacturado1.agregarDetalleArticuloManufacturado(detalleArticuloManufacturado1);
			articuloManufacturado2.agregarDetalleArticuloManufacturado(detalleArticuloManufacturado2);


			//Vinculamos el rubro gral a los articulos manu --------------------------------

			articuloManufacturado1.setRubroGeneral(rubroGeneral1);
			articuloManufacturado2.setRubroGeneral(rubroGeneral1);

			articuloManufacturadoRepository.save(articuloManufacturado1);
			articuloManufacturadoRepository.save(articuloManufacturado2);

			// VINCULAR DETALLE ART MANU CON ARTICULO INSUMO

			detalleArticuloManufacturado1.setArticuloInsumo(articuloInsumo1);
			detalleArticuloManufacturado2.setArticuloInsumo(articuloInsumo2);

			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado1);
			detalleArticuloManufacturadoRepository.save(detalleArticuloManufacturado2);

			//CREO CLIENTE -----------------------------------------------------------------

			Cliente cliente1 = Cliente.builder()
					.nombre("Leonel")
					.apellido("Messi")
					.email("leomessi10@gmail.com")
					.telefono("261605548")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			Cliente cliente2 = Cliente.builder()
					.nombre("Arnaldo")
					.apellido("Gomez")
					.email("arnaldo10@gmail.com")
					.telefono("261568548")
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);


			//CREO DOMICILIO ---------------------------------------------------------------

			Domicilio domicilio1 = Domicilio.builder()
					.calle("Alvarez Condarco")
					.codigoPostal(5533)
					.localidad("El Vergel")
					.pisoDpto(5)
					.numero(22)
					.numeroDpto(3)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			Domicilio domicilio2 = Domicilio.builder()
					.calle("Matienzo")
					.codigoPostal(8899)
					.localidad("Colonia Junin")
					.pisoDpto(7)
					.numero(26)
					.numeroDpto(9)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			domicilioRepository.save(domicilio1);
			domicilioRepository.save(domicilio2);

			//CREO USUARIO -----------------------------------------------------------------

			Usuario usuario1 = Usuario.builder()
					.auth0Id("User01")
					.username("Unknow15")
					.rol(Rol.Cajero)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();
			Usuario usuario2 = Usuario.builder()
					.auth0Id("User02")
					.username("Unknow88")
					.rol(Rol.Cliente)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.build();

			usuarioRepository.save(usuario1);
			usuarioRepository.save(usuario2);

			//VINCULAR DOMICILIO CON CLIENTE -----------------------------------------------

			cliente1.setDomicilio(domicilio1);
			cliente2.setDomicilio(domicilio2);

			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);

			//VINCULAR CLIENTE CON USUARIO -------------------------------------------------

			cliente1.setUsuario(usuario2);
			cliente2.setUsuario(usuario1);

			clienteRepository.save(cliente1);
			clienteRepository.save(cliente2);


			//CREAR ISNTANCIA DETALLE PEDIDO -----------------------------------------------

			DetallePedido detallePedido1 = DetallePedido.builder()
					.cantidad(2)
					.subtotal(800)
					.subtotalCosto(500)
					.build();
			DetallePedido detallePedido2 = DetallePedido.builder()
					.cantidad(4)
					.subtotal(600)
					.subtotalCosto(5000)
					.build();

			/*detallePedidoRepository.save(detallePedido1);
			detallePedidoRepository.save(detallePedido2);*/

			//CREAR INSTANCIA DE PEDIDO ----------------------------------------------------

			Pedido pedido1 = Pedido.builder()
					.estado(EstadoPedido.Preparacion)
					.formaPago(FormaPago.Efectivo)
					.tipoEnvio(TipoEnvio.TakeAway)
					.total(600)
					.totalCosto(900)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.fechaPedido(fecha)
					.horaEstimadaFinalizacion(fecha)
					.build();

			Pedido pedido2 = Pedido.builder()
					.estado(EstadoPedido.Iniciado)
					.formaPago(FormaPago.TC)
					.tipoEnvio(TipoEnvio.Delivery)
					.total(800)
					.totalCosto(1000)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.fechaPedido(fecha)
					.horaEstimadaFinalizacion(fecha)
					.build();


			//AGREGAR DETALLES AL PEDIDO ---------------------------------------------------

			pedido1.agregarDetallePedido(detallePedido1);
			pedido2.agregarDetallePedido(detallePedido2);

			//AGREGAR DOMICILIO AL PEDIDO --------------------------------------------------

			pedido1.setDomicilio(domicilio1);
			pedido2.setDomicilio(domicilio2);

			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);


			//CREAR INSTANCIA DE MP --------------------------------------------------------

			MercadoPagoDatos mercadoPagoDatos1 = MercadoPagoDatos.builder()
					.estado("Pagado")
					.formaPago("Debito")
					.identificadorPago(8)
					.nroTarjeta("0880-989")
					.metodoPago("Bancario")
					.fechaAprobacion(fecha)
					.fechaCreacion(fecha)
					.build();
			MercadoPagoDatos mercadoPagoDatos2 = MercadoPagoDatos.builder()
					.estado("En transanccion")
					.formaPago("Debito")
					.identificadorPago(9)
					.nroTarjeta("0880-555")
					.metodoPago("Retiro en vantana")
					.fechaCreacion(fecha)
					.fechaAprobacion(fecha)
					.build();

			mercadoPagoDatosRepository.save(mercadoPagoDatos1);
			mercadoPagoDatosRepository.save(mercadoPagoDatos2);

			//AGREGAR EL MP AL PEDIDO -----------------------------------------------------

			pedido1.setMercadoPagoDatos(mercadoPagoDatos1);
			pedido2.setMercadoPagoDatos(mercadoPagoDatos2);
			//AGREGAR CLIENTES AL PEDIDO --------------------------------------------------

			pedido1.setCliente(cliente1);
			pedido2.setCliente(cliente2);

			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);

			//CREAR DETALLE FACTURA -------------------------------------------------------

			DetalleFactura detalleFactura1 = DetalleFactura.builder()
					.cantidad(8)
					.subtotal(800)
					.build();
			DetalleFactura detalleFactura2 = DetalleFactura.builder()
					.cantidad(4)
					.subtotal(960)
					.build();
			DetalleFactura detalleFactura3 = DetalleFactura.builder()
					.cantidad(9)
					.subtotal(8000)
					.build();

			/*detalleFacturaRepository.save(detalleFactura1);
			detalleFacturaRepository.save(detalleFactura2);*/


			//CREAR INSTANCIAS FACTURA ----------------------------------------------------

			Factura factura1 = Factura.builder()
					.formaPago(FormaPago.TC)
					.mpMerchantOrderId(15)
					.mpPaymentId(3)
					.mpPreferenceId("MP568")
					.mpPaymentType("MP999")
					.totalVenta(8000)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.fechaFacturacion(fecha)
					.build();

			Factura factura2 = Factura.builder()
					.formaPago(FormaPago.Efectivo)
					.mpMerchantOrderId(65)
					.mpPaymentId(37)
					.mpPreferenceId("MP998")
					.mpPaymentType("MP785")
					.totalVenta(10000)
					.fechaAlta(fecha)
					.fechaBaja(fecha)
					.fechaModificacion(fecha)
					.fechaFacturacion(fecha)
					.build();

			//VINCULAR FACTURA CON DETALLE FACTURA

			factura1.agregarDetalleFactura(detalleFactura1);
			factura1.agregarDetalleFactura(detalleFactura2);
			factura2.agregarDetalleFactura(detalleFactura3);

			// VINCULAR FACTURA CON PEDIDO ------------------------------------------------

			pedido1.setFactura(factura1);
			pedido2.setFactura(factura2);

			pedidoRepository.save(pedido1);
			pedidoRepository.save(pedido2);


			// VINCULAR DETALLE PEDIDO CON LOS ARTICULOS -----------------------------------

			detallePedido1.setArticuloInsumo(articuloInsumo1);
			detallePedido1.setArticuloManufacturado(articuloManufacturado1);
			detallePedidoRepository.save(detallePedido1);

			detallePedido2.setArticuloManufacturado(articuloManufacturado2);
			detallePedido2.setArticuloInsumo(articuloInsumo2);
			detallePedidoRepository.save(detallePedido2);

			//VINCULAR DETALLEFACTURA CON LOS ARTICULOS -----------------------------------

			detalleFactura1.setArticuloInsumo(articuloInsumo1);
			detalleFactura1.setArticuloManufacturado(articuloManufacturado1);
			detalleFacturaRepository.save(detalleFactura1);

			detalleFactura2.setArticuloManufacturado(articuloManufacturado2);
			detalleFactura2.setArticuloInsumo(articuloInsumo2);
			detalleFacturaRepository.save(detalleFactura2);

			detalleFactura3.setArticuloInsumo(articuloInsumo2);
			detalleFactura3.setArticuloManufacturado(articuloManufacturado1);
			detalleFacturaRepository.save(detalleFactura3);

			//Vincular detalle art manuf con Art Insumo ------------------------------------

			detalleArticuloManufacturado1.setArticuloInsumo(articuloInsumo1);
			detalleArticuloManufacturado2.setArticuloInsumo(articuloInsumo2);



		};
	}
}