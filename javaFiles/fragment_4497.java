LatLng mainUserLocation = new LatLng(Double.valueOf(currentLt), Double.valueOf(currentLn));

LatLng otherPlayersLocation = new LatLng(currentLtAU, currentLnAU);

    public void showMap() {

        mMap.clear();
        //Create your Markers List
        List<Marker> markersList = new ArrayList<Marker>();
        Marker youMarker = mMap.addMarker(new MarkerOptions().position(mainUserLocation).title("You"));
        Marker playerMarker = mMap.addMarker(new MarkerOptions().position(otherPlayersLocation).title(nameAU));

        //Add them to your list
        markersList.add(youMarker);
        markersList.add(playerMarker);


//get the latLngbuilder from the marker list
        builder = new LatLngBounds.Builder();
        for (Marker m : markersList) {
            builder.include(m.getPosition());
        }

//Bounds padding here
        int padding = 50;

        //Create bounds here
        LatLngBounds bounds = builder.build();

//Create camera with bounds
        cu = CameraUpdateFactory.newLatLngBounds(bounds, padding);

//Check map is loaded
        mMap.setOnMapLoadedCallback(new GoogleMap.OnMapLoadedCallback() {
            @Override
            public void onMapLoaded() {
                //animate camera here
                mMap.animateCamera(cu);

            }
        });


}