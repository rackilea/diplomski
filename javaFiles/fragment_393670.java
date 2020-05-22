JSONObject obj = new JSONObject(content);
    JSONArray products = obj.getJSONArray("products");
    for(int i = 0; i < products.length(); ++i){
        String name = products.getJSONObject(i).getString("name");
        JSONArray array = products.getJSONObject(i).getJSONArray("deviceIdSensorIdArr");
        for (int j = 0; j < array.length(); j++) {
            String string = array.getJSONObject(j).getString("deviceId");
            System.out.println(string);
        }
    }