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
		
		//Creacion del Data
		Map data = new HashMap();
		data.put("tipoDocumento", 1);
		data.put("otrosDatos", "otros valores");
		
		//Creacion del Header
		Map header = new HashMap();
		header.put("Authorization", "Bearer api_key_" + apiKey);
		header.put("Content-Type", "application/json");
		
		ArrayList<Map> datas = new ArrayList<Map>();
		datas.add(data);
		
		Map result = HttpUtil.invocarRest(url, method, gson.toJson(datas), header);
		
		System.out.println("Result=> " + gson.toJson(result));

	}
}
