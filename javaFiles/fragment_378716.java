public class AsyncGeocoder extends AsyncTask<AsyncGeocoderObject, Void, List<Address>> {

private TextView textView;

@Override
protected List<Address> doInBackground(AsyncGeocoderObject... asyncGeocoderObjects) {
    List<Address> addresses = null;
    AsyncGeocoderObject asyncGeocoderObject = asyncGeocoderObjects[0];
    textView = asyncGeocoderObject.textView;
    try {
        addresses = asyncGeocoderObject.geocoder.getFromLocation(asyncGeocoderObject.location.getLatitude(),
                asyncGeocoderObject.location.getLongitude(), 1);
    } catch (IOException e) {
        e.printStackTrace();
    }
    return addresses;
}

@Override
protected void onPostExecute(List<Address> addresses) {
    Log.v("onPostExecute", "location: " + addresses);
    String address;
    if (addresses != null)
        address = addresses.get(0).getLocality() + ", " + addresses.get(0).getCountryName();
    else address = "Service unavailable.";
    textView.setText(address);
}
}