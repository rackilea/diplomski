import groovy.inspect.swingui.GeneratedBytecodeAwareGroovyClassLoader;
import io.restassured.RestAssured;
import io.restassured.http.Method;
import io.restassured.path.json.JsonPath;
import org.json.JSONObject;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import org.testng.annotations.Test;

import junit.framework.Assert;

@Test
public void getUserIdTest() throws IOException, ParseException, SQLException {

        String baseUrl = readPropertiesFile().getProperty("baseUrl");
        RestAssured.baseURI = baseUrl;
        RequestSpecification httpRequest = RestAssured.given();
        Response response = httpRequest.request(Method.GET, "myApiPath");
        String jsonResponseString = response.getBody().asString();
        //String jsonResponseString = "{\n    \"123\": {\n        \"userId\": 424,\n        \"firstName\": \"abc\",\n        \"lastName\": \"xyz\",\n        \"username\": \"abc\",\n        \"email\": \"abc@gmail.com\",\n        \"status\": 1\n    },\n    \"234\": {\n        \"userId\": 937,\n        \"firstName\": \"xyz\",\n        \"lastName\": \"abc\",\n        \"username\": \"xyz\",\n        \"email\": \"xyz@mailinator.com\",\n        \"status\": 0\n    }\n}";
        JSONObject jsonObject = new JSONObject(jsonResponseString);
        Iterator<String> keys = jsonObject.keys();

        String firstkey =keys.next(); 

        JSONObject jsonObjectElement = new JSONObject( jsonObject.get(firstkey).toString());
        String userId = jsonObjectElement.get("userId").toString();
        Assert.assertEquals(424, Integer.parseInt(userId));

}