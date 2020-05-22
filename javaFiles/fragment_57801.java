@Override
    public void onLocationChanged(Location location) {
        tvLocation = (TextView) findViewById(R.id.tv_location);

        // Getting latitude of the current location
        latitude = location.getLatitude();

        // Getting longitude of the current location
        longitude = location.getLongitude();

        // Creating a LatLng object for the current location
        LatLng latLng = new LatLng(latitude, longitude);

        // Showing the current location in Google Map
        map.moveCamera(CameraUpdateFactory.newLatLng(latLng));

        // Zoom in the Google Map
        map.animateCamera(CameraUpdateFactory.zoomTo(15));

        map.addMarker(new MarkerOptions().position(
                new LatLng(latitude, longitude)).title(addressText));

        map.setOnMarkerClickListener(new GoogleMap.OnMarkerClickListener() {

            @Override
            public boolean onMarkerClick(Marker marker) {
                Toast.makeText(getBaseContext(), "marker clicked",
                        Toast.LENGTH_LONG).show();
                return false;
            }

        });

        // TODO Auto-generated method stub

        Geocoder geoCoder = new Geocoder(this);

        try {
            matches = geoCoder.getFromLocation(latitude, longitude, 1);
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        Address bestMatch = (matches.isEmpty() ? null : matches.get(0));
        addressText = String.format("%s, %s, %s", bestMatch
                .getMaxAddressLineIndex() > 0 ? bestMatch.getAddressLine(0)
                : "", bestMatch.getLocality(), bestMatch.getCountryName());

    }

    @Override
    public void onMapLongClick(LatLng point) {
        // TODO Auto-generated method stub

    }

    @Override
    public void onMapClick(LatLng point) {
        // TODO Auto-generated method stub

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }