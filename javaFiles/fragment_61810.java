public class ApiEndpointHelper {

    private RequestSpecification givenAuthJson() {
        return RestAssured.given()
            .auth()
            .basic("userbob", "bobspassword")
            .contentType(ContentType.JSON)
    }

    public static String getId() {
        Response response = givenAuthJson()
            .when()
            .get("http://localhost:3099/v1/");
    }
}