public JSONObject getCurrentLocationViaJSON(double lat, double lng) {
// Returns a JSONObject with route (street_address), street_number, postal_code and country

    JSONObject jsonObj = getLocationInfo(lat, lng);
    Log.i("JSON string =>", jsonObj.toString());

    String currentLocation = "testing";
    String route = null;
    String street_number = null;
    String postal_code = null; 
    String country = null;

    try {
        String status = jsonObj.getString("status").toString();
        Log.i("status", status);

        if(status.equalsIgnoreCase("OK")){
            JSONArray results = jsonObj.getJSONArray("results");
            int i = 0;
            Log.i("i", i+ "," + results.length() ); //TODO delete this
            do{

                JSONObject r = results.getJSONObject(0);
                JSONArray addressComponentsArray = r.getJSONArray("address_components");
                JSONArray addressComponents = addressComponentsArray.getJSONObject(i);
                JSONArray typesArray = addressComponents.getJSONArray(0);
                String types = typesArray.getString(0);

                if(types.equalsIgnoreCase("street_number")){
                    street_number = addressComponents.getString("short_name");
                    Log.i("street_number", street_number);
                }else if(types.equalsIgnoreCase("postal_code")){
                    postal_code = addressComponents.getString("long_name");
                    Log.i("postal_code", postal_code);
                }else if(types.equalsIgnoreCase("country")){
                    country = addressComponents.getString("long_name");
                    Log.i("country", country);
                }else if(types.equalsIgnoreCase("route")){
                    route = addressComponents.getString("long_name");
                    Log.i("postal_code", postal_code);
                }

                i++;
            }while(i<results.length());

            Log.i("JSON Geo Locatoin =>", currentLocation);
            return currentLocation;
        }

    } catch (JSONException e) {
        Log.e("testing","Failed to load JSON");
        e.printStackTrace();
    }

    JSONObject json = new JSONObject(); 
    json.put("street_number", street_number); 
    json.put("postal_code", postal_code); 
    json.put("country ", country); 
    json.put("route", route); 

    return json;
}