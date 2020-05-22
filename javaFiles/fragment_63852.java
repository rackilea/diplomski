map.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
    @Override
    public void onMapLoaded() {
        map.moveCamera(CameraUpdateFactory.newLatLngBounds(bounds, 15));
        map.setMapType(GoogleMap.MAP_TYPE_HYBRID);
    }
});