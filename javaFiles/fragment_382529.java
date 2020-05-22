String myJson =  "{" +
"  \"lastUpdated\":1404620562," +
"  \"invasions\":{" +
"    \"Vibrant Valley\":{" +
"      \"asOf\":1404620562," +
"      \"type\":\"Penny Pincher\"," +
"      \"progress\":\"959/1000\"" +
"    }" +
"  }," +
"  \"error\":null" +
"}"

JsonElement jelement = new JsonParser().parse(myJson);
JsonObject  jobject = jelement.getAsJsonObject();
long lastUpdated = jobject.get("lastUpdated").getAsLong();