public MarkerOptions createMarker(Double latitude, final Double longitude, String Plate_num) {

    // list = new ArrayList<>(); // Don't do this

    BitmapDescriptor image = BitmapDescriptorFactory.fromResource(R.drawable.bus);

   return new MarkerOptions()
            .position(new LatLng(latitude, longitude))
            .title("Plate No.")
            .snippet(Plate_num)
            .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE)));
}