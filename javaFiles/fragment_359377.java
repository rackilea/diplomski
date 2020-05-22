private static void buildJsonUsingObjectModelApi() {
  System.out.println("Json Building using Object Model API");
  JsonArray jsonArray =
          //Create an Array Builder to build an JSON Array
          Json.createArrayBuilder()
            .add(Json.createObjectBuilder()//Create an Object builder to build JSON Object
              .add("parentid", 23424900)
              .add("name","Jackson")
              .add("url", "http://where.yahooapis.com/v1/place/2428184")
              .add("placeType", Json.createObjectBuilder()//Another nested JSON Object
                    .add("name", "Town")
                    .add("code",7)
                  )
              .add("woeid", 116545)
              .build()//The JSON Object completely constructed.
            )
            .add(Json.createObjectBuilder()//Another object builder to build JSON Object.
              .add("name","Mexico City")
              .add("url", "http://where.yahooapis.com/v1/place/116545")
              .add("placeType", Json.createObjectBuilder()
                    .add("name", "Town")
                    .add("code",7)
                  )
              .add("parentid", 23424977)
              .add("woeid", 2428184)
              .build()
             )
            .build();
  StringWriter writer = new StringWriter();

  //Extracting the JSON data from the JSON object tree into the string.
  Json.createWriter(writer).writeArray(jsonArray);

  System.out.println(writer.toString());

}