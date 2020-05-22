// Jackson
ObjectMapper mapper = new ObjectMapper();
String followerName = mapper.readTree(jsonStr)
        .get("data")
        .get(0)
        .get("from_name")
        .asText();
System.out.println(followerName);

// Gson     
followerName = new JsonParser().parse(jsonStr)
        .getAsJsonObject()
        .get("data")
        .getAsJsonArray()
        .get(0)
        .getAsJsonObject()
        .get("from_name")
        .getAsString();
System.out.println(followerName);