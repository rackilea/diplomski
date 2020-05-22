public static JSONObject createJson(Map<String, String> value) {
    JSONObject result = new JSONObject();
    JSONArray addresses = new JSONArray();
    result.put("addresses", addresses);

    value.entrySet().stream()       //iterate the map
        .map(e -> {                 //build an object
            JSONObject address = new JSONObject();
            address.put("address", e.getKey());
            address.put("domain", e.getValue());
            return address;
        })
        .forEach(addresses::put);   //insert into the array

    return result;
}