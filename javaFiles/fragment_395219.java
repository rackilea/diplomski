...
for (DataSnapshot s : dataSnapshot.getChildren()) {
    final member user = s.getValue(member.class);
    LatLng location = new LatLng(user.lat, user.lon);

    Marker marker = mMap.addMarker(new MarkerOptions().position(location).title(user.name));
    marker.setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));
    marker.setTag(user);  // <--- store user object at marker tag
}

// move it outside of loop
mMap.setInfoWindowAdapter(new GoogleMap.InfoWindowAdapter() {
    @Override
    public View getInfoWindow(Marker marker) {
        return null;
    }
    @Override
    public View getInfoContents(Marker marker) {
        // get object user from marker tag and cast it to "member" class
        final member user = (member) (marker.getTag());

        View v= getLayoutInflater().inflate(R.layout.coustume,null);
        TextView nam = v.findViewById(R.id.name);
        TextView emai = v.findViewById(R.id.email);
        TextView famy = v.findViewById(R.id.family);
        TextView seed = v.findViewById(R.id.plant);
        ImageView image=v.findViewById(R.id.imagev);
        nam.setText(user.name);
        Picasso.get().load(user.imagepath).into(image);
        emai.setText("Email ID:"+user.email);
        famy.setText("Family Members:  " + user.numbf);
        seed.setText("Plants:    " +user.numbs);
        LatLng location = new LatLng(user.lat, user.lon);

        // remove line below to avoid marker "re-creation" on every getInfoContents() call
        //mMap.addMarker(new MarkerOptions().position(location).title(user.name)).setIcon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_YELLOW));

        return v;
    }
}
...