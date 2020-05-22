private void getDBLocations(JSONArray j){
ArrayList<LocationData> locations = new ArrayList<LocationData>();

// Traversing through all the items in the Json array
for(int i=0;i<j.length();i++){
    try{
        //Getting json object
        JSONObject json = j.getJSONObject(i);

        LocationData location = new LocationData();            
        location.setName(json.getString(Config.TAG_NAME));
        location.setType(json.getString(Config.TAG_TYPE));
        location.setLongitude(json.getDouble(Config.TAG_LONGITUDE));
        location.setLatitude(json.getDouble(Config.TAG_LATITUDE));

        locations.add(location);
    }catch (JSONException e){
        e.printStackTrace();
    }
}
}