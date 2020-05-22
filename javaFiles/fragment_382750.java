Criteria myCriteria = new Criteria();
    myCriteria.setCostAllowed(false);
    LocationProvider myLocationProvider = LocationProvider.getInstance(myCriteria);
    Location myLocation = myLocationProvider.getLocation(300);
    latitude  = myLocation.getQualifiedCoordinates().getLatitude();
    longitude = myLocation.getQualifiedCoordinates().getLongitude();