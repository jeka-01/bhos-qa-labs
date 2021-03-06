package com.example.springproj5;

import org.json.JSONException;
import org.json.JSONObject;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import java.util.Collections;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class Springproj5ApplicationTests {

    String FIREBASE_SIGNIN_EMAIL_PASSWORD = "https://identitytoolkit.googleapis.com/v1/accounts:signInWithPassword?key=";
    String FRBS_WEB_API_KEY = System.getenv("FIREBASE_WEB_API_KEY");
    String FIRESTORE_COLLECTION = "https://firestore.googleapis.com/v1/projects/architecture-d8267/databases/(default)/documents/users/";

    TestRestTemplate rTemp = new TestRestTemplate();

    @Test
    void testingFirebase() throws JSONException {
        HttpHeaders hdrs = new HttpHeaders();

        JSONObject jsonObject = new JSONObject();
        jsonObject.put("email", "zeka.abbasov.bhos@gmail.com");
        jsonObject.put("password", "salam123");
        jsonObject.put("returnSecureToken", true);

        HttpEntity<String> entity = new HttpEntity<>(jsonObject.toString(), hdrs);
        ResponseEntity<String> response = rTemp.exchange(FIREBASE_SIGNIN_EMAIL_PASSWORD + FRBS_WEB_API_KEY, HttpMethod.POST, entity, String.class);

        JSONObject responseBody = new JSONObject(response.getBody());
        String idToken = responseBody.getString("idToken");
        String localId = responseBody.getString("localId");


        HttpHeaders headers2 = new HttpHeaders();
        headers2.put("Authorization", Collections.singletonList("Bearer ".concat(idToken)));

        HttpEntity<String> entity2 = new HttpEntity<>(null, headers2);
        ResponseEntity<String> response2 = rTemp.exchange(FIRESTORE_COLLECTION + localId, HttpMethod.GET, entity2, String.class);

        JSONObject resBody2 = new JSONObject(response2.getBody());
        JSONObject fields = resBody2.getJSONObject("fields");

        JSONObject name = fields.getJSONObject("name");
        JSONObject surname = fields.getJSONObject("surname");
        JSONObject phone = fields.getJSONObject("phone");


        assertEquals("timur", name.getString("stringValue"));
        assertEquals("abbasov", surname.getString("stringValue"));
        assertEquals("077", phone.getString("stringValue"));

    }
}