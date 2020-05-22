LatLngBounds.Builder builder = new LatLngBounds.Builder();
builder.include(latlng);

map.setOnCameraChangeListener(new OnCameraChangeListener() {

@Override
public void onCameraChange(CameraPosition arg0) {
    // Move camera
    map.moveCamera(CameraUpdateFactory.newLatLngBounds(builder.build(), 10));
    // Remove listener to prevent position reset on camera move
    map.setOnCameraChangeListener(null);
}