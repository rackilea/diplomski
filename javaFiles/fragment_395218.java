...
for (DataSnapshot s : dataSnapshot.getChildren()) {
            final member user = s.getValue(member.class);
            LatLng location = new LatLng(user.lat, user.lon);
            mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
                @Override
                public View getInfoWindow(Marker marker) {
                    return null;
                }
                ...
             }
    mMap.addMarker(new MarkerOptions().position(location).title(user.name)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
}
...