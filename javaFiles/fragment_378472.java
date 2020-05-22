private Marker marker;

@Override
public void onMapReady(GoogleMap googleMap) {
    mMap = googleMap;
    LatLng latLon = new LatLng(13.0827, 80.2707);
    marker = mMap.addMarker(new MarkerOptions().position(latLon).title("Marker is in Chennai.").snippet("India"));
    mMap.moveCamera(CameraUpdateFactory.newLatLng(latLon));
}

@SuppressWarnings("StatementWithEmptyBody")
@Override
public boolean onNavigationItemSelected(MenuItem item) {
    // Handle navigation view item clicks here.
    int id = item.getItemId();

    double lat = 0;
    double lon = 0;

    if (id == R.id.redBuilding){
        lat = 13.010982;
        lon = 80.235444;

        mMap.moveCamera(CameraUpdateFactory.newLatLng(new LatLng(lat, lon));
        marker.setPosition(new LatLng(lat, lon));
        marker.setTitle("your new title");
    }

    if (id == R.id.nav_share) {
    } else if (id == R.id.nav_send) {
    }

    DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
    drawer.closeDrawer(GravityCompat.START);
    return true;
}