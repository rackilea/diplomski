getMap().setOnMapClickListener(new GoogleMap.OnMapClickListener() {
        @Override
        public void onMapClick(LatLng latLng) {
            getMap().animateCamera(CameraUpdateFactory.zoomIn());
        }
    });