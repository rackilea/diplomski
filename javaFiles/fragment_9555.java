RestAssuredMatchers.given().
        param("store","0123").
    when().
        get(REQUEST_MAPPING + "/vehicles/{niv}/serviceHistory", niv).
    then().
        statusCode(200);