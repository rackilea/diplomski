private double getDistanceInMeter(LatLng start, LatLng end) {
    Location startPoint=new Location("locationA");
    startPoint.setLatitude(start.latitude);
    startPoint.setLongitude(start.longitude);

    Location endPoint=new Location("locationB");
    endPoint.setLatitude(end.latitude);
    endPoint.setLongitude(end.longitude);

    double distance=startPoint.distanceTo(endPoint);

    return distance;
}