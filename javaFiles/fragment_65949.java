List<TrackPoint> tp = new ArrayList<TrackPoint>();    

for (int i = 0; i < tp.size()-1; i++) {
    double lat1 = tp.get(i).getLat();                        
    double lat2 = tp.get(i + 1).getLat();
    double lon1 = tp.get(i).getLon();                       
    double lon2 = tp.get(i + 1).getLon();
    double radlat1 = Math.PI * lat1 / 180;
    double radlat2 = Math.PI * lat2 / 180;
    double theta = lon1 - lon2;
    double radtheta = Math.PI * theta / 180;
    double dist = Math.sin(radlat1) * Math.sin(radlat2) + Math.cos(radlat1) * Math.cos(radlat2) * Math.cos(radtheta);
    dist = Math.acos(dist);
    dist = dist * 180 / Math.PI;
    dist = dist * 60 * 1.1515; 
    dist = dist * 1609.344;// distance in miles
    double _KM = 1000; //KM the unit of distance                       
    //distance in km
    double distInKM = dist / _KM;
    DecimalFormat df = new DecimalFormat("###.###");
    double dt = Double.parseDouble(df.format(distInKM));
    double mileage = 0;
    mileage += mileage + dt;       
    tp.get(i).setMileage(mileage);                       
}