public void checkCountry(LatLng location) {
    Geocoder gcd = new Geocoder(this, Locale.getDefaut());
    List<Address> addresses=new ArrayList<>();
    try{
        addresses=  gcd.getFromLocation(location.latitude, location.longitude, 1); //error here
    }catch (Exception e){
        e.printStackTrace();
    }
    String country;
    if(addresses!=null)if(addresses.size()!=0) country= addresses.get(0).getCountryName();
}