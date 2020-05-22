// jsonText is the string representation of your JSON
JSONObject jsonObjectWrapper = new JSONObject(jsonText);  

// get the "artists" object
JSONObject jsonArtists = jsonObjectWrapper.get("artists");

// get the array and pass it to Jackson's ObjectMapper, using TypeReference
  // to deserialize the JSON ArrayList to a Java ArrayList.
List<Artist> artists = objectMapper.readValue(
        jsonObjectWrapper.getString("artist"),
            new TypeReference<ArrayList<Artist>>() { });