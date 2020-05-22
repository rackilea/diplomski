JSONObject json;
    try {
        //create main JSONObject
        json = new JSONObject(response);

        //get results array
        JSONArray results = json.getJSONArray("results");

        //get first JSONObjects in the array
        JSONObject firstObj = results.getJSONObject(0);

        //get JSONObject for key "geometry"
        JSONObject geometry = firstObj.getJSONObject("geometry");

        //get JSONObject for key "location"
        JSONObject location = geometry.getJSONObject("location");

        //get strings for keys "lat" and "lng"
        String lat = location.getString("lat");
        String lng = location.getString("lng");

    } catch (JSONException e) {
        e.printStackTrace();
    }