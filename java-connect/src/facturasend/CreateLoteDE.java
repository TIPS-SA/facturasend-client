package facturasend;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import util.HttpUtil;

/**
 * API = https://docs.facturasend.com.py/?shell#creacion-de-varios-des
 * 
 * @author tips
 *
 */
public class CreateLoteDE {
	static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

	public static void main(String[] args) throws Exception {
		
		String url = "http://localhost:3002/api/empresa0/de/create";
		//String url = "https://api.facturasend.com.py/<tenantId>/de/create";
		String apiKey = "324234242342342432343432";
		String method = "POST";
		ArrayList<Map> datas = new ArrayList<Map>();
		
		while(datas.size() <= 50) {
			//Creacion del data.cliente
			Map cliente = new HashMap();
			cliente.put("contribuyente" , true);
			cliente.put("ruc" , "2005001-1");
			cliente.put("razonSocial" , "Marcos Adrian Jara Rodriguez");
			cliente.put("nombreFantasia" , "Marcos Adrian Jara Rodriguez");
			cliente.put("tipoOperacion" , 1);
			cliente.put("direccion" , "Avda Calle Segunda y Proyectada");
			cliente.put( "numeroCasa" , "1515");
			cliente.put("departamento" , 11);//si tipodocumento es 4(autofactura) o 5(notaCredito) o 6 (notaDebito) o 7(notaRemision)
			cliente.put("departamentoDescripcion" , "ALTO PARANA");//si tipodocumento == 4 (autofactura) o 6 (notaDebito) o 7(notaRemision)
			cliente.put("distrito" , 143);//si tipodocumento es 4(autofactura) o 5(notaCredito) o 6 (notaDebito) o 7(notaRemision)
			cliente.put("distritoDescripcion" , "DOMINGO MARTINEZ DE IRALA2");//si tipodocumento == 4 (autofactura) o 6 (notaDebito) o 7(notaRemision)
			cliente.put("ciudad" , 3344);
			cliente.put( "ciudadDescripcion" , "PASO ITA (INDIGENA)");
			cliente.put("pais" , "PRY");
			cliente.put("paisDescripcion" , "Paraguay");
			cliente.put( "tipoContribuyente" , 1);
			cliente.put("documentoTipo" , 1);
			cliente.put("documentoNumero" , "2324234");
			cliente.put( "telefono" , "0973515487");
			cliente.put("celular" , "0973542154");
			cliente.put("email" , "cliente@cliente.com");
			cliente.put("codigo" , "1548");
			
			//Creacion del data.usuario
			Map usuario = new HashMap();
			usuario.put("documentoTipo" , 1);
			usuario.put("documentoNumero" , "157264");
			usuario.put("nombre" , "Marcos Jara");
			usuario.put("cargo" , "Vendedor");
			
			//Creacion del data.remision
			Map remision = new HashMap();
			remision.put("motivo" , 1);
			remision.put("tipoResponsable" , 1);
			remision.put("kms" , 150);
			remision.put("fechaFactura" , "2021-10-21");
			
			//Creacion del data.notaCreditoDebito
			// si es tipodocumento 5(notaCredito) o 6 (notaDebito)
			Map notaCreditoDebito = new HashMap();
			notaCreditoDebito.put("motivo" , 1);
			
			//Creacion del data.factura
			Map factura = new HashMap();
			factura.put("presencia" , 1);
			
			
			//Creacion del data.autofactura.ubicacion
			Map autoFactura_ubicacion = new HashMap();
			autoFactura_ubicacion.put("lugar" , "Donde se realiza la transaccion");
			autoFactura_ubicacion.put("departamento" , 11);
			autoFactura_ubicacion.put("departamentoDescripcion" , "ALTO PARANA");
			autoFactura_ubicacion.put("distrito" , 145);
			autoFactura_ubicacion.put("distritoDescripcion" , "CIUDAD DEL ESTE");
			autoFactura_ubicacion.put("ciudad" , 3420);
			autoFactura_ubicacion.put("ciudadDescripcion" , "DON BOSCO");
			
			//Creacion del data.autofactura
			Map autoFactura = new HashMap();
			autoFactura.put("tipoVendedor" , 1);
			autoFactura.put("documentoTipo" , 1);
			autoFactura.put("documentoNumero" , "235306");
			autoFactura.put("nombre" , "Marcos Jara Delgado");
			autoFactura.put("direccion" , "Area 4");
			autoFactura.put("numeroCasa" , "001");
			autoFactura.put( "departamento" , 11);
			autoFactura.put("departamentoDescripcion" , "ALTO PARANA");
			autoFactura.put("distrito" , 145);
			autoFactura.put("distritoDescripcion" , "CIUDAD DEL ESTE");
			autoFactura.put("ciudad" , 3420);
			autoFactura.put("ciudadDescripcion" , "DON BOSCO");
			autoFactura.put("ubicacion", autoFactura_ubicacion);
			
	
			
			//Creacion del data.condicion.entregas.infoTarjeta
			Map condicion_entregas_tarjeta = new HashMap();
			condicion_entregas_tarjeta.put("numero" , 1234);
			condicion_entregas_tarjeta.put("tipo" , 1);
			condicion_entregas_tarjeta.put("tipoDescripcion" , "Dinelco");
			condicion_entregas_tarjeta.put("numeroTarjeta", 3232);
			condicion_entregas_tarjeta.put("titular" , "Marcos Jara");
			condicion_entregas_tarjeta.put("ruc" , "69695654-1");
			condicion_entregas_tarjeta.put("razonSocial" , "Bancard");
			condicion_entregas_tarjeta.put("medioPago" , 1);
			condicion_entregas_tarjeta.put("codigoAutorizacion" , 232524234);
			
			//Creacion del data.condicion.infoCheque
			Map condicion_entregas_cheque = new HashMap();
			condicion_entregas_cheque.put("numeroCheque", "32323232");
			condicion_entregas_cheque.put("banco" , "Sudameris");
			
			//Creacion del data.condicion.credito.infoCuotas
			//hacer con un ciclo dependiendo de la cantidad de cuotas
			Map condicion_credito_cuotas = new HashMap();
			condicion_credito_cuotas.put("moneda" , "PYG");
			condicion_credito_cuotas.put("monto" , 800000.00);
			condicion_credito_cuotas.put("vencimiento" , "2021-10-30");
			
			//Creacion del data.condicion.credito
			Map condicion_credito = new HashMap();
			condicion_credito.put("tipo" , 1);
			condicion_credito.put("plazo" , "30 días");
			condicion_credito.put("cuotas" , 2);
			condicion_credito.put("montoEntrega" , 1500000.00);
			condicion_credito.put("infoCuotas", condicion_credito_cuotas);
			
			//Creacion del data.condicion.entregas
			Map condicion_entregas = new HashMap();
			condicion_entregas.put("tipo" , 1);
			condicion_entregas.put("monto" , "150000");
			condicion_entregas.put("moneda" , "PYG");
			condicion_entregas.put("monedaDescripcion" , "Guarani");
			condicion_entregas.put("cambio" , 0.0);// si es efectivo
			condicion_entregas.put("infoTarjeta", condicion_entregas_tarjeta);//si es con tarjeta
			condicion_entregas.put("infoCheque", condicion_entregas_cheque);//si es con cheque
			
			//Creacion del data.condicion
			Map condicion = new HashMap();
			condicion.put("tipo" , 1);
			condicion.put("entregas", condicion_entregas);// si es contado
			condicion.put("credito",condicion_credito );// si es credito
			
			//Creacion del data.items.dncp
			//si tipodocumento == 4 (autofactura)
			Map items_dncp = new HashMap();
			items_dncp.put("codigoNivelGeneral" , "12345678");
			items_dncp.put("codigoNivelEspecifico" , "1234");
			items_dncp.put("codigoGtinProducto" , "12345678");
			items_dncp.put("codigoNivelPaquete" , "12345678");
			
			//Creacion del data.items.dncp
			//si tipodocumento == 4 (autofactura)
			Map items_importador = new HashMap();
			items_importador.put("nombre" , "Importadora Parana S.A.");
			items_importador.put("direccion" , "Importadora Parana S.A.");
			items_importador.put("registroImportador" , "Importadora Parana S.A.");
			items_importador.put("registroSenave" , "Importadora Parana S.A.");
			items_importador.put("registroEntidadComercial" , "Importadora Parana S.A.");
			
			//Creacion del data.items
			//hacer con un ciclo por la cantidad de items
			Map items = new HashMap();
			items.put("codigo" , "A-001");
			items.put("descripcion", "Producto o Servicio 1");
			items.put("observacion", "Cualquier informacion de interes");
			items.put("ncm", "123456");
			items.put("unidadMedida", 77);
			items.put("cantidad", 10.5);
			items.put("precioUnitario", 10800);
			items.put("tolerancia" , 1);//si tipodocumento == 4 (autofactura) o 7(notaRemision)
			items.put("toleranciaCantidad" , 1);//si tipodocumento == 4 (autofactura) o 7(notaRemision)
			items.put("toleranciaPorcentaje" , 1);//si tipodocumento == 4 (autofactura) o 7(notaRemision)
			items.put("cdcAnticipo" , "44digitos");//si tipodocumento == 4 (autofactura)
			items.put("dncp" ,items_dncp );//si tipodocumento == 4 (autofactura)
			items.put("cdcAnticipo" , "44digitos");//si es tipoDocumento 7(notaRemision)
			items.put("ivaTipo" , 1);
			items.put("ivaBase" , 100);
			items.put("iva" , 5);
			items.put("lote" , "A-001");//si tipodocumento == 4 (autofactura) o 6 (notaDebito) o 7(notaRemision)
			items.put("vencimiento" , "2022-01-30");//si tipodocumento == 4 (autofactura) o 6 (notaDebito) o 7(notaRemision)
			items.put("numeroSerie" , "");//si tipodocumento == 4 (autofactura)
			items.put("numeroPedido" , "");//si tipodocumento == 4 (autofactura)
			items.put("numeroSeguimiento" , "");//si tipodocumento == 4 (autofactura)
			items.put("importador", items_importador);//si tipodocumento == 4 (autofactura)
			
			//Creacion del data.complementarios.carga
			//si tipodocumento == 4 (autofactura)
			Map complementarios_carga = new HashMap();
			complementarios_carga.put("unidadMedidaVolumenTotal" , null);
			complementarios_carga.put("volumenTotal" , 10);
			complementarios_carga.put("unidadMedidaPesoTotal" , null);
			complementarios_carga.put("pesoTotal" , 11);
			complementarios_carga.put("caracteristicaCarga" , null);
			complementarios_carga.put( "caracteristicaCargaDescripcion" , null);
			
			//Creacion del data.complementarios
			//si tipodocumento == 4 (autofactura)
			Map complementarios = new HashMap();
			complementarios.put("ordenCompra" , 1001);
			complementarios.put("ordenVenta" , 1002);
			complementarios.put("numeroAsiento" , 1212);
			complementarios.put("carga", complementarios_carga);
			
			//Creacion del data.detalleTransporte.salida
			//si tipodocumento == 7(notaRemision)
			Map salida = new HashMap();
			salida.put("direccion" , "Paraguay");
			salida.put("numeroCasa" , "3232");
			salida.put("complementoDireccion1" , "Entre calle 2");
			salida.put("complementoDireccion2" , "y Calle 7");
			salida.put("departamento" , 11);
			salida.put("departamentoDescripcion" , "ALTO PARANA");
			salida.put("distrito" , 143);
			salida.put("distritoDescripcion" , "DOMINGO MARTINEZ DE IRALA");
			salida.put("ciudad" , 3344);
			salida.put("ciudadDescripcion" , "PASO ITA (INDIGENA)");
			salida.put("pais" , "PRY");
			salida.put("paisDescripcion" , "Paraguay");
			salida.put("telefonoContacto" , "097x");
			
			//Creacion del data.detalleTransporte.entrega
			//si tipodocumento == 7(notaRemision)
			Map entrega = new HashMap();
			entrega.put("direccion" , "Paraguay");
			entrega.put("numeroCasa" , "3232");
			entrega.put("complementoDireccion1" , "Entre calle 2");
			entrega.put("complementoDireccion2" , "y Calle 7");
			entrega.put("departamento" , 11);
			entrega.put("departamentoDescripcion" , "ALTO PARANA");
			entrega.put("distrito" , 143);
			entrega.put("distritoDescripcion" , "DOMINGO MARTINEZ DE IRALA");
			entrega.put("ciudad" , 3344);
			entrega.put("ciudadDescripcion" , "PASO ITA (INDIGENA)");
			entrega.put("pais" , "PRY");
			entrega.put("paisDescripcion" , "Paraguay");
			entrega.put("telefonoContacto" , "097x");
			
			//Creacion del data.detalleTransporte.vehiculo
			//si tipodocumento == 7(notaRemision)
			Map vehiculo = new HashMap();
			vehiculo.put( "tipo" , "Camioneta");
			vehiculo.put("marca" , "Nissan");
			vehiculo.put("documentoTipo" , 1);
			vehiculo.put("documentoNumero" , "232323-1");
			vehiculo.put( "obs" , "");
			vehiculo.put("numeroMatricula" , "ALTO PARANA");
			vehiculo.put("numeroVuelo" , "32123");
			
			
			//Creacion del data.detalleTransporte.transportista.chofer
			//si tipodocumento == 7(notaRemision)
			Map chofer = new HashMap();
			chofer.put("documentoNumero" , "32324253");
			chofer.put("nombre" , "Jose Benitez");
			chofer.put("direccion" , "Jose Benitez");
			
			
			
			//Creacion del data.detalleTransporte.transportista.agente
			//si tipodocumento == 7(notaRemision)
			Map agente = new HashMap();
			agente.put("nombre" , "Jose Benitez");
			agente.put("ruc" , "251458-1");
			agente.put("direccion" , "Jose Benitez");
			
			
			//Creacion del data.detalleTransporte.transportista
			//si tipodocumento == 7(notaRemision)
			Map transportista = new HashMap();
			transportista.put("contribuyente" , true);
			transportista.put("nombre" , "EMPRESA DE TRANSPORTE VANGUARDIA S A C I");
			transportista.put("ruc" , "80011235-0");
			transportista.put( "documentoTipo" , 1);
			transportista.put("documentoNumero" , "235306");
			transportista.put("direccion" , "y Calle 7");
			transportista.put("obs" , 11);
			transportista.put("pais" , "PRY");
			transportista.put("paisDescripcion" , "Paraguay");
			transportista.put("chofer", chofer);
			transportista.put("agente", agente);
	
			//Creacion del data.detalleTransporte
			//si tipodocumento == 7(notaRemision)
			Map detalleTransporte = new HashMap();
			detalleTransporte.put("tipo" , 1);
			detalleTransporte.put("modalidad" , 1);
			detalleTransporte.put("tipoResponsable" , 1);
			detalleTransporte.put("condicionNegociacion" , "FOB");
			detalleTransporte.put("numeroManifiesto" , "AF-2541");
			detalleTransporte.put("numeroDespachoImportacion" , "153223232332");
			detalleTransporte.put("inicioEstimadoTranslado" , "2021-11-01");
			detalleTransporte.put("finEstimadoTranslado" , "2021-11-01");
			detalleTransporte.put("paisDestino" , "PRY");
			detalleTransporte.put("paisDestinoNombre" , "Paraguay");
			detalleTransporte.put("salida", salida);
			detalleTransporte.put("entrega", entrega);
			detalleTransporte.put("vehiculo", vehiculo);
			detalleTransporte.put("transportista", transportista);
			
			
			
			//Creacion del data.documentoAsociado
			//si tipodocumento es 4(autofactura) o 5(notaCredito)  o 6 (notaDebito) o 7(notaRemision)
			Map docAsoc = new HashMap();
			docAsoc.put("formato" , 3);//si tipodocumento es 4(autofactura) o 5(notaCredito) o 6 (notaDebito) o 7(notaRemision)
			docAsoc.put("constanciaTipo" , 1);//si tipodocumento es 4(autofactura) 
			docAsoc.put("constanciaNumero" , 42845716);//si tipodocumento es 4(autofactura)
			docAsoc.put("constanciaControl" , "8f9708d2");//si tipodocumento es 4(autofactura) 
			docAsoc.put("cdc" , "01800695631001002100702012022071214269428290");//si tipodocumento es 5(notaCredito) o 6 (notaDebito)  o 7(notaRemision)
			
			//Creacion del Data
			Map data = new HashMap();
			data.put("tipoDocumento", 1);
			data.put("establecimiento",1 );
			data.put("punto", "002");
			data.put("numero", 102364);
			data.put("descripcion", "Aparece en el documento");
			data.put("observacion", "Cualquier informacion de interes");
			data.put("fecha", "2022-08-18T10:11:00");
			data.put("tipoEmision" , 1);
			data.put("tipoContribuyente" , 1);//si tipodocumento es 4(autofactura) o 5(notaCredito) o 6 (notaDebito) o 7(notaRemision) 
			data.put("tipoTransaccion" , 1);
			data.put("tipoImpuesto" , 1);
			data.put("moneda" , "PYG");
			data.put("condicionAnticipo" , null);//si tipodocumento == 4 (autofactura) o 6 (notaDebito)
			data.put("condicionTipoCambio", null);//si tipodocumento == 4 (autofactura) o 6 (notaDebito)
			data.put("cambio", 6700.0);//si tipodocumento == 4 (autofactura) o 6 (notaDebito) o 7(notaRemision)
			data.put("cliente", cliente);
			data.put("usuario", usuario);
			data.put("notaCreditoDebito", notaCreditoDebito);//si tipodocumento es 5(notaCredito) o 6 (notaDebito)
			data.put("remision", remision);//si tipodocumento == 7(notaRemision)
			data.put("factura", factura);// solo si tipodocumento == 1 (factura)
			data.put("autoFactura", autoFactura);//si tipodocumento == 4 (autofactura)
			data.put("condicion", condicion);//si tipodocumento == 4 (autofactura) o 1 (factura)
			data.put("items", items);
			data.put("complementarios", complementarios);//si tipodocumento == 4 (autofactura)
			data.put("detalleTransporte",detalleTransporte); //si tipodocumento == 7 (notaRemision) 
			data.put("documentoAsociado", docAsoc);//si tipodocumento es 4(autofactura) o 5(notaCredito) o 6 (notaDebito) o 7(notaRemision) 
			
			
			datas.add(data);
		}
		//Creacion del Header
		Map header = new HashMap();
		header.put("Authorization", "Bearer api_key_" + apiKey);
		header.put("Content-Type", "application/json");
		
		Map result = HttpUtil.invocarRest(url, method, gson.toJson(datas), header);
		
		System.out.println("Result=> " + gson.toJson(result));

	}
}
