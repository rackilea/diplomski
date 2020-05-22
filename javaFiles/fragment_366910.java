LocationResult locationResult = new LocationResult(){
    @Override
    public void gotLocation(Location location){
        //Got the location!
        //Here goes your code
        //This method will be called when location data arrive
    }
};
MyLocation myLocation = new MyLocation();
myLocation.getLocation(this, locationResult);