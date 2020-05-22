List<Address> addresses = null;

try {
    addresses = geocoder.getFromLocationName(adress, 1);
} catch (IOException e) {
    e.printStackTrace();
}
Address address = addresses.get(0);