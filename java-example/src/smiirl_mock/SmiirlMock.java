package smiirl_mock;

import static spark.Spark.get;
import static spark.Spark.port;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.Gson;

public class SmiirlMock {
	public static void main(String[] args) {
		port(80);

		get("/v1.0/:mac/:secret", (req, res) -> {
			res.type("application/json");

			Map<String, Object> response = new HashMap<>();
			response.put("result", true);
			response.put("status", true);
			response.put("v", "smiirl_2.0.7-1");
			response.put("attribute", "number");
			response.put("url", "http://api.smiirl.com/" + req.params(":mac") + "/number");
			response.put("interval", 300);
			response.put("code", 200);

			return new Gson().toJson(response);
		});

		get("/:mac/number", (req, res) -> {
			res.type("application/json");

			Map<String, Object> response = new HashMap<>();
			response.put("number", 12345);

			return new Gson().toJson(response);
		});
	}
}
