map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
        @Override
        public void onMyLocationChange(Location location) {
            double lat =  location.getLatitude();
            double lng = location.getLongitude();
            //TODO: Send longitude and latitude to JAVA app
        }
    });