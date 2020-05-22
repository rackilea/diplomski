JsonFactory factory = new JsonFactory();       
    factory.setCodec(new ObjectMapper());
    JsonParser  parser  = factory.createParser(jsonresponse);
    while(!parser.isClosed()){
        JsonToken jsonToken = parser.nextToken();

        if(JsonToken.FIELD_NAME.equals(jsonToken)){
            String fieldName = parser.getCurrentName();
            if("report".equals(fieldName)) {
                jsonToken = parser.nextToken();
                Report report = parser.readValueAs(Report.class);       
            } else {
                jsonToken = parser.nextToken();
            }
        }
    }