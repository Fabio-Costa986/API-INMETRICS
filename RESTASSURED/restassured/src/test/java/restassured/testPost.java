package restassured;

import static org.junit.Assert.assertEquals;

import org.json.simple.JSONObject;
import org.junit.Test;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class testPost {
	
	@Test
	public void empregadoCadastrar() {
		
		RequestSpecification request = RestAssured.given().auth().preemptive().basic("inmetrics", "automacao");
		request.header("Content-Type", "application/json");
		JSONObject json = new JSONObject();
		
		json.put("admissao", "01/01/2005");
		json.put("cargo", "analista de teste");
		json.put("comissao", "1.000,00");
		json.put("cpf", "362.843.120-40");
		json.put("departamentoId", "1");
		json.put("nome", "Elvis Presley");
		json.put("salario", "1.000,00");
		json.put("sexo", "m");
		json.put("tipoContratacao", "clt");
		
		request.body(json.toJSONString());
		Response response = request.post("https://inm-test-api.herokuapp.com/empregado/cadastrar");
		System.out.println("Cadastro " + response.asString());
		
		int statusCod = response.getStatusCode();
		assertEquals(202, statusCod);
		
		
	}
	

}
