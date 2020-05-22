Map<String, Object>  jsonAsMap = new HashMap<>();
map.put("key", "val");

given().
        contentType(ContentType.JSON).
        body(jsonAsMap).
when().
        post(url + resource).
then().
        statusCode(200).
        body("otherVal", equalTo(otherVal));