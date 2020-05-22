Response response = RestAssured.given().
             headers("data",crypto). 
             when().
             post("//auth.svc/auth").
             then().contentType(ContentType.JSON).
             extract().response();