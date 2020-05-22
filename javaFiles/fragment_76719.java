given().queryParam(
            "api_key", "A813302*************", 
            "method", "my",
            "from", "91xxxxxxx")
            .body("{\n" +
            "  \"to\":\"91xxxxxxxx\",\n" +
            " \"type\": \"image\", \"image\" : {\"caption\" : \"{{caption}}\"},\n" +
            "\"callback\":\"{{callback}}\"\n" +
            "}")
            .multiPart(new File("C:/Users/sobhit.s/Pictures/SMS-2047.png"))
            .when()
            .get(ExecutionConfig.BASE_URL)
            .prettyPrint();