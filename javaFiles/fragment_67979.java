@Override
public void onMapReady(GoogleMap googleMap) {
    map = googleMap;
    map.setOnCameraChangeListener(new GoogleMap.OnCameraChangeListener() {
        @Override
        public void onCameraChange(CameraPosition cameraPosition) {
            showPolygons();
        }
    });
    showPolygons();
}

private void showPolygons() {
    if (map == null) return;
    final LatLngBounds bounds = map.getProjection().getVisibleRegion().latLngBounds;
    for (PolygonOptionsWrapper wrapper : wrappers) {
        if (wrapper.within(bounds)) {
            if (!wrapper.isAdded()) {
                wrapper.addTo(map);
            }
        } else {
            if (wrapper.isAdded()) {
                wrapper.removeFrom(map);
            }
        }
    }
}