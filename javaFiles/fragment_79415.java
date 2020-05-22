given().
        contentType(ContentType.JSON).
        body(new HashMap<String,Object>() {{
             put("key1, "val1");
             put("key2, "val2");
             put("key3", asList("val3", "val4"));
             put("nested", new HashMap<String,String>() {{
                 put("key4", "val4");
                 put("key5", "val5");
             }});
        }}).
when().
        post(url + resource).
then().
        statusCode(200).
        body("otherVal", equalTo(otherVal));