package com.springproj1.springproj1;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.json.*;

import java.io.IOException;


@SpringBootTest
class Springproj1ApplicationTests {

	public boolean isJSONValid(String test) {
		try {
			new JSONObject(test);
		} catch (JSONException ex) {
			try {
				new JSONArray(test);
			} catch (JSONException ex1) {
				return false;
			}
		}
		return true;
	}

	@Test
	void contextLoads() throws IOException {
		Springproj1Application obj = new Springproj1Application();
		Assertions.assertEquals(true, isJSONValid(obj.perform("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos")));
		Assertions.assertEquals(true, isJSONValid(obj.perform("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos/1/branches")));
		Assertions.assertEquals(true, isJSONValid(obj.perform("https://60a21d3f745cd70017576092.mockapi.io/api/v1/repos/1/branches/1/commits")));
	}

}
