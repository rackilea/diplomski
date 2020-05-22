// Convert the string (sb is a string butter from the http response) to a json array. 
JSONArray jArray = new JSONArray(sb.toString());

for(int i = 0; i < jArray.length(); i++){
    // Get each item as a JSON object. 
    JSONObject json_data = jArray.getJSONObject(i);

    // Get data from object ... 
    Int a = json_data.getInt("a");
    String b = json_data.getString("b");
    String c = json_data.getString("c");
    String d = json_data.getString("d");

    // Do whatever with the data ... 
}