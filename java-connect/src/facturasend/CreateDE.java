package facturasend;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import util.HttpUtil;

/**
 * API = https://docs.facturasend.com.py/#creacion-de-un-de
 * 
 * @author tips
 *
 */
public class CreateDE {
	static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

	public static void main(String[] args) throws Exception {
		
		String url = "http://localhost:3002/api/empresa0/de/create";
		//String url = "https://api.facturasend.com.py/<tenantId>/de/create";
		String method = "POST";
		
		//Creacion del Data
		Map data = new HashMap();
		data.put("tipoDocumento", 1);
		data.put("otrosDatos", "otros valores");
		
		//Creacion del Header
		Map header = new HashMap();
		header.put("Authorization", "Bearer api_key_<hdiweuw-92jwwle...>");
		header.put("Content-Type", "application/json");
		
		Map result = HttpUtil.invocarRest(url, method, gson.toJson(data), header);
		
		System.out.println("Result=> " + gson.toJson(result));

	}
}
