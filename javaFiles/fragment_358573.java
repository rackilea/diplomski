if(HomeFragment.googleMap != null){
    LocationManager locationManager = (LocationManager)getApplicationContext().getSystemService(Context.LOCATION_SERVICE);
    Criteria criteria = new Criteria();

    Location location = locationManager
            .getLastKnownLocation(locationManager.getBestProvider(criteria,
                    false));
    if (location != null) {
        HomeFragment.googleMap
                .animateCamera(CameraUpdateFactory.newLatLngZoom(
                        new LatLng(location.getLatitude(), location
                                .getLongitude()), 13));

        CameraPosition cameraPosition = new CameraPosition.Builder()
                .target(new LatLng(location.getLatitude(), location
                        .getLongitude())) // Sets the center of the map to
                                            // location user
                .zoom(14) // Sets the zoom
                .bearing(0) // Sets the orientation of the camera to east
                .tilt(40) // Sets the tilt of the camera to 30 degrees
                .build(); // Creates a CameraPosition from the builder
        HomeFragment.googleMap.animateCamera(CameraUpdateFactory
                .newCameraPosition(cameraPosition));

    }
}else{
            fragment = new HomeFragment();}
            mDrawerLayout.closeDrawers();
            break;