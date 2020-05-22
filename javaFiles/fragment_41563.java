private static final String LATITUDE = "com.somepackage.name.LATITUDE";
private static final String LONGITUDE = "com.somepackage.name.LONGITUDE";

/**
 * Save a location/key pair.
 * 
 * @param key the key associated with the location
 * @param location the location for the key
 * @return true if saved successfully false otherwise
 */
public boolean saveLocation(String key, Location location) {
    LOG.info("Saving location");
    try {
        JSONObject locationJson = new JSONObject();

        locationJson.put(LATITUDE, location.getLatitude());
        locationJson.put(LONGITUDE, location.getLongitude());
        //other location data
        SharedPreferences.Editor edit = preferences.edit();
        edit.putString(key, locationJson.toString());
        edit.commit();
    } catch (JSONException e) {
        LOG.error("JSON Exception", e);
        return false;
    }

    LOG.info("Location {}  saved successfully at key: {}", preferences.getString(key, null),key);
    return true;
}

/**
 * Gets location data for a key.
 * 
 * @param key the key for the saved location
 * @return a {@link Location} object or null if there is no entry for the key
 */
public Location getLocation(String key) {
    LOG.info("Retrieving location at key {} ", key);
    try {
        String json = preferences.getString(key, null);

        if (json != null) {
            JSONObject locationJson = new JSONObject(json);
            Location location = new Location(STORAGE);
            location.setLatitude(locationJson.getInt(LATITUDE));
            location.setLongitude(locationJson.getInt(LONGITUDE));
            LOG.info("Returning location: {}" , location);
            return location;
        }
    } catch (JSONException e) {
        LOG.error("JSON Exception", e);
    }

    LOG.warn("No location found at key {}",  key);
    //or throw exception depending on your logic
    return null;
}