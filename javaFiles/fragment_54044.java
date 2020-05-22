public GeoPoint getLocationFromAddress(String strAddress){

Geocoder coder = new Geocoder(this);
List<Address> address;
GeoPoint p1 = null;

try {
    address = coder.getFromLocationName(strAddress,5);
    if (address==null) {
       return null;
    }
    Address location=address.get(0);
    location.getLatitude();
    location.getLongitude();

p1 = new GeoPoint((double) (location.getLatitude() * 1E6),
                  (double) (location.getLongitude() * 1E6));

return p1;
}
}