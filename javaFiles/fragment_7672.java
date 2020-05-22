RestAssured.
    given().
            contentType("application/x-www-form-urlencoded; charset=ISO-8859-1").
            formParam("key1", value1).
            formParam("key1", value2).
            formParam("key2", value3).
    when().
            post("Some URL");