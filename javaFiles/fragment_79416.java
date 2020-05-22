MyDTO myDTO = new MyDTO(...);
given().
        contentType(ContentType.JSON).
        body(myDTO).
when().
        post(url + resource).
then().
        statusCode(200).
        body("otherVal", equalTo(otherVal));