private void onResult(Clinic clinic, @Nullable Exception e){
    this.clinic = new Clinic(clinic.getName(), clinic.getAddress(), clinic.getDescription(), clinic.getGeoPoint());
    MarkerOptions markerOptions = new MarkerOptions();
    LatLng coordinates = new LatLng(clinic.getGeoPoint().getLatitude(), clinic.getGeoPoint().getLongitude());
    markerOptions.position(coordinates);

    getActivity().runOnUiThread(() -> {
        map.addMarker(markerOptions);
    });
}