@Override
    public void onLocationChanged(Location newLocation) {
        if (isBetterLocation(GeoLocation.this.currentLocation, newLocation)) {
            GeoLocation.this.currentLocation = newLocation;
            for(LocationListener l:listeners){
                l.onLocationChanged(newLocation);
            }
        }
   ... the rest of the code