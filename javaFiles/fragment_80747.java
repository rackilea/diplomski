JSONObject data = new JSONObject(dataInfo); // get the entire JSON into an object
JSONObject info = data.getJSONObject("information"); // get the 'information' object
JSONArray dataArray = info.getJSONArray("data"); // get the 'data' array

for (int i = 0; i < dataArray.length(); i++) {
    // foreach element in the 'data' array
    JSONObject dataObj = dataArray.getJSONObject(i); // get the object from the array
    JSONObject datum = dataObj.getJSONObject("datum"); // get the 'datum' object
    String type = datum.getString("type"); // get the 'type' string

    if ("Student".equals(type)) {
        // do your processing for 'Student' here
    }
}