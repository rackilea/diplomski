List<Address> addresses;
Geocoder geocoder = new Geocoder(getActivity());
addresses = geocoder.getFromLocation(latitude, longitude, 10);
if (addresses == null || addresses.isEmpty()) {
    // Mygeocoder is a class with a http request to google server, that replaces Geocoder, if not work
    addresses = MyGeocoder.getFromLocation(latitude, longitude, 10);
}

HashMap itemAddress;
ArrayList itemList = new ArrayList<HashMap<String, String>>();

Log.d("Addresses", "" + "Start to print the ArrayList");
for (int i = 0; i < addresses.size(); i++) {
    itemAddress = new HashMap<String, String>();
    Address address = addresses.get(i);
    String addressline = "Addresses from getAddressLine(): ";
    for (int n = 0; n <= address.getMaxAddressLineIndex(); n++) {
        addressline += " index n: " + n + ": " + address.getAddressLine(n) + ", ";
    }
    Log.d("Addresses: ", addressline);
    Log.d("Addresses getAdminArea()", "" + address.getAdminArea());
    Log.d("Addresses getCountryCode()", "" + address.getCountryCode());
    Log.d("Addresses getCountryName()", "" + address.getCountryName());
    Log.d("Addresses getFeatureName()", "" + address.getFeatureName());
    Log.d("Addresses getLocality()", "" + address.getLocality());
    Log.d("Addresses getPostalCode()", "" + address.getPostalCode());
    Log.d("Addresses getPremises()", "" + address.getPremises());
    Log.d("Addresses getSubAdminArea()", "" + address.getSubAdminArea());
    Log.d("Addresses getSubLocality()", "" + address.getSubLocality());
    Log.d("Addresses getSubThoroughfare()", "" + address.getSubThoroughfare());
    Log.d("Addresses getThoroughfare()", "" + address.getThoroughfare());
}