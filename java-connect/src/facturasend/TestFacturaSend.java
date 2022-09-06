package facturasend;

import java.util.Map;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import util.HttpUtil;

/**
 * API = https://docs.facturasend.com.py/#test-de-facturasend
 * 
 * @author tips
 *
 */
public class TestFacturaSend {
	static Gson gson = new GsonBuilder().setDateFormat("yyyy-MM-dd'T'HH:mm:ss").create();

	public static void main(String[] args) throws Exception {
		
		//String url = "http://localhost:3002/api/test";
		String url = "https://api.facturasend.com.py/test";
		String method = "GET";
		Map result = HttpUtil.invocarRest(url, method, null, null);

		System.out.println("Result=> " + gson.toJson(result));
	}
}
