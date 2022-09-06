<?php
class API 
{
    private $url;
    private $tenantId;
    private $apikey;
    function __construct($url, $tenantid, $apikey){
        $this->url = $url;
        $this->tenantId = $tenantid;
        $this->apikey = $apikey;
    }

    function testApi() { 
        $curl = curl_init(); 
        curl_setopt($curl, CURLOPT_URL, $this->url."test"); 
        $result = curl_exec($curl); 
        curl_close($curl); 
        return $result;
    }

    function testApi2() { 
        $curl = curl_init(); 
        curl_setopt($curl, CURLOPT_URL, $this->url.$this->tenantId."/test"); 
        curl_setopt($curl, CURLOPT_HTTPHEADER, array(
            'Authorization: Bearer api_key_' . $this->apikey
            ));
        $result = curl_exec($curl); 
        curl_close($curl);
        return $result;
    }

    function testApiDeCreate($data) { 
        /*Aqui podria usarse el json_encode para mejor validacion de los datos a ser
        enviados*/
        $curl = curl_init(); 
        curl_setopt($curl, CURLOPT_URL, $this->url.$this->tenantId."/de/create"); 
        curl_setopt($curl, CURLOPT_HTTPHEADER, array(
            'Content-Type: application/json',
            'Authorization: Bearer api_key_' . $this->apikey
            ));
        curl_setopt($curl, CURLOPT_POSTFIELDS, $data);
        $result = curl_exec($curl); 
        curl_close($curl);
        return $result;
    }
    
}

$api = new API('192.168.100.31:3004/api/', "monalisa", "9EB9E4B3-680E-45D3-AEF0-CE12639866EF");
echo "Test1 Api<br>";
$res = $api->testApi();


echo "<br><br>Test2 Api<br>";
$res = $api->testApi2();

echo "<br><br>Test3 Api<br>";
$data = '{"factura":{"presencia":1},"usuario":{"nombre":"TIPS S.A.","documentoNumero":"80069563-1","cargo":"Vendedor","documentoTipo":1},"ruc":"23131313","moneda":"PYG","establecimiento":1,"observacion":"","tipoEmision":1,"tipoDocumento":1,"tipoImpuesto":1,"fecha":"2022-07-19T10:49:49","descripcion":"","punto":1,"tipoTransaccion":2,"numero":60,"condicion":{"tipo":1,"entregas":[{"monedaDescripcion":"Guaranies","tipo":99,"moneda":"PYG","tipoDescripcion":"Documento","monto":190000},{"monedaDescripcion":"Guaranies","tipo":1,"moneda":"PYG","monto":300000},{"monedaDescripcion":"Guaranies","tipo":99,"moneda":"PYG","tipoDescripcion":"Boleta de Depósito","monto":300000},{"monedaDescripcion":"Guaranies","tipo":99,"moneda":"PYG","tipoDescripcion":"Vale","monto":210000}]},"cliente":{"direccion":"ALAS PARAGUAYAS  NUMERO 98","ciudad":5946,"pais":"PRY","razonSocial":"NORA FRANCO","numeroCasa":"0","distrito":"159","telefono":"","departamentoDescripcion":"CENTRAL","documentoNumero":"2115296","pais_descripcion":"PARAGUAYA","codigo":"1750","contribuyente":false,"distritoDescripcion":"LUQUE","email":"","nombreFantasia":"","departamento":"12","tipoOperacion":2,"tipoContribuyente":1,"documentoTipo":1,"celular":"0983267030","ciudadDescripcion":"LUQUE"},"items":[{"pais":"PRY","ivaTipo":1,"codigo":124,"descuento":0,"observacion":"  ","cantidad":1,"paisDescripcion":"PARAGUAYA","descripcion":"transferenca a cuenta de gregorio","subtotal":1000000,"ivaBase":100,"iva":10,"precioUnitario":1000000,"importador":{},"dncp":{},"unidadMedida":77}],"cdc":null,"codigoSeguridadAleatorio":883916761,"tipoDocumentoDescripcion":"Factura electrónica"}';
//$res = $api->testApiDeCreate($data);
?>