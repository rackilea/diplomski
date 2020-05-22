public static List<Address> getGeoLocation(String address, Context context){

    Geocoder go = new Geocoder(context);
    List<Address> addresses = null;
    try {
        addresses = go.getFromLocationName(address, 1);


    } catch (IOException e) {
                Toast.makeText(context, e.getMessage(), Toast.LENGTH_LONG).show();
    }

    return addresses;
}