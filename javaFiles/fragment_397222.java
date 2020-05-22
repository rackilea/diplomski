public static void main(String[] args) {
    String response = "{ \"book\": [ " + 
            "      { \"category\": \"\"," + 
            "        \"author\": \"Nigel Rees\"," + 
            "        \"title\": \"Sayings of the Century\"," + 
            "        \"price\": \"\"" + 
            "      }," + 
            "      { \"category\": \"fiction\"," + 
            "        \"author\": \"\"," + 
            "        \"title\": \"Sword of Honour\"," + 
            "        \"price\": \"12.99\"" + 
            "      }," + 
            "      { \"category\": \"fiction\"," + 
            "        \"author\": \"Herman Melville\"," + 
            "        \"title\": \"Moby Dick\"," + 
            "        \"isbn\": \"0-553-21311-3\"," + 
            "        \"price\": \"8.99\"" + 
            "      }," + 
            "      { \"category\": \"fiction\"," + 
            "        \"author\": \"J. R. R. Tolkien\"," + 
            "        \"title\": \"The Lord of the Rings\"," + 
            "        \"isbn\": \"0-395-19395-8\"," + 
            "        \"price\": 22.99" + 
            "      }" + 
            "    ]" + 
            "}";
    int length = JsonPath.read(response, "$.book.length()");
    System.out.println(length);
    Configuration conf = Configuration.defaultConfiguration();

    Object document = Configuration.defaultConfiguration().jsonProvider().parse(response);

    for (int i = 0; i < length; i++) {
        String json = conf.jsonProvider().toJson(JsonPath.read(document, "$.book["+i+"]"));
        System.out.println(json);
        //process(json);
    }
}