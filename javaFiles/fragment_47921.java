private void centerOnMyLocation() {

    map.setMyLocationEnabled(true);

    location = map.getMyLocation();

    if (location != null) {
        myLocation = new LatLng(location.getLatitude(),
                location.getLongitude());
    }
    map.animateCamera(CameraUpdateFactory.newLatLngZoom(myLocation,
            Constants.MAP_ZOOM));
}