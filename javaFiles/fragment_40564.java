public void ReloadMarkerFragment() {
    mMap.clear();

    if (!latitudeSetting.equals("") && !longitudeSetting.equals("")) {
        latitude = Double.parseDouble(latitudeSetting);
        longitude = Double.parseDouble(longitudeSetting);
    }

    setMarker(latitude, longitude, "", userName, "");

    fetchAllrestaurants(userId);
}