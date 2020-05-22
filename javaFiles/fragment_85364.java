ObjectMapper mapper = new ObjectMapper();
JsonParser parser = mapper.getJsonFactory().createJsonParser(new File(ConfigurationManager.jsonfile));

JsonToken token = parser.nextToken();

if (token == null) {
    System.out.println("no json file");
}

if (!JsonToken.START_ARRAY.equals(token)) {
    System.out.println("Expected an array");
}   

while (!JsonToken.END_ARRAY.equals(parser.nextToken())) {   
    System.out.println(parser.readValueAsTree().toString()));

    // parse json object here
}       

parser.close();