private static void buildJsonUsingStreamingApi() {

  //Create a StringWriter instance to buffer the JSON data.
  StringWriter writer = new StringWriter();

  //Create a JSON generator backed by the StringWriter instance created above.
  JsonGenerator generator = Json.createGenerator(writer);

  //Start building the JSON Data- Uses Method chaining technique.
  //The JSON data gets streamed in the buffer as and when the
  //different methods are invoked.
  generator.writeStartArray()
            .writeStartObject()//Indicates the start of an JSON object
              .write("parentid", 23424900)
              .write("name","Mexico City")
              .write("url", "http://where.yahooapis.com/v1/place/116545")
              .writeStartObject("placeType")//Creating a nested object i.e an JSON object withing another object
                .write("name","Town")
                .write("code", 7)
              .writeEnd()
              .write("woeid", 116545)
            .writeEnd()//Indicates the end of an JSON object
            .writeStartObject()
              .write("name","Jackson")
              .write("url", "http://where.yahooapis.com/v1/place/2428184")
              .writeStartObject("placeType")
                .write("name","Town")
                .write("code", 7)
              .writeEnd()
            .write("parentid", 23424977)
            .write("woeid", 2428184)
            .writeEnd()
          .writeEnd();//Indicates the end of the JSON array.
  //Writes the data in the buffer to the String buffer.
  generator.flush();

  //Prints the JSON data onto the console.
  System.out.println(writer.toString());
}