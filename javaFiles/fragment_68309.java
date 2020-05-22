double minLong = Double.MAX_VALUE;
double minLat = Double.MAX_VALUE;
double maxLong = -Double.MIN_VALUE;
double maxLat = -Double.MIN_VALUE;

for(Station station : stations){

    if(station.getLatitude()>maxLat){
        maxLat = station.getLongitude();
        maxLong = station.getLongitude();
    }
    if(station.getLatitude()<minLat){
        minLat = station.getLongitude();
        minLong = station.getLongitude();
    }
    if(station.getLongitude()>maxLong){
        maxLong = station.getLongitude();
    }
    if(station.getLongitude()<minLong){
        minLong = station.getLongitude();
    }
}