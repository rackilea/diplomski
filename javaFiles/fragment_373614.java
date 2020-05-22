client.getLastLocation().addOnSuccessListener(getActivity(), new OnSuccessListener<Location>() {
    @Override
    public void onSuccess(Location location) {
        lat=location.getLatitude();
        lon=location.getLongitude();
    }
});
Toast.makeText(getActivity(),lat+"",Toast.LENGTH_LONG).show();

// Firebase update code that depends on location data