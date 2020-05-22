public String address() {
    Geocoder geoCoder = new Geocoder(getBaseContext(), Locale.getDefault());
    String result = "";
    try {
        List<Address> addresses =
            geoCoder.getFromLocation(LocationManagerHelper.getLatitude() / 1E6,
                                     LocationManagerHelper.getLongitude() / 1E6,
                                     1);
            if (addresses.size() > 0) {
                Address address = addresses.get(0);
                for (int i = 0; i < address.getMaxAddressLineIndex(); i++)
                    result += address.getAddressLine(i) + "\n";
            }
    } catch (IOException e) {
        e.printStackTrace();
    }
    return result;
}