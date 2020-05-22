for (User user : usersList) {

    final LatLng latlng = new LatLng(user.getLastLocation().getLatitude(), user.getLastLocation().getLongitude());

    Marker previousMarker = mMarkerMap.get(user.getId());
    if (previousMarker != null) {
        //previous marker exists, update position:
        previousMarker.setPosition(latlng);
    } else {
        //No previous marker, create a new one:
        MarkerOptions markerOptions = new MarkerOptions()
                .position(latlng)
                .title(user.getId());

        Marker marker = mMap.addMarker(markerOptions);

        //put this new marker in the HashMap:
        mMarkerMap.put(user.getId(), marker);
    }
}