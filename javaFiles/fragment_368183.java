class MyLocationResult extends/implments LocationResult{
    double currentLat;
    double currentLon;

    @Override 
    public void gotLocation(Location location){ 
        currentLat = location.getLatitude(); 
        currentLon = location.getLongitude(); 
    };
    public double getCurrentLat(){
       return currentLat;
    }
    public double getCurrentLon (){
       return currentLon ;
    }
}