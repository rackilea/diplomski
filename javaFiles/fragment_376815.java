LatLngBounds.Builder builder = new LatLngBounds.Builder();
for (Location loc : allLocations) {

    LatLng position = new LatLng(loc.getLatitude(), loc.getLongitude());
    builder.include(position);

}

CameraUpdate cu = CameraUpdateFactory.newLatLngBounds(builder.build(), someMarginValue);
map.moveCamera(cu);