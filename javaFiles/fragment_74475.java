// fetch the object      
    JSONObject obj = new JSONObject(result);

   // fetch the data array
    JSONArray jArray = obj.getJSONArray("data");

    // Extract data from json and store into ArrayList
    for (int i = 0; i < jArray.length(); i++) {
        JSONObject json_data = jArray.getJSONObject(i);
        dataList.add(json_data.getString("name"));
    }