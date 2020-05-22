map.setMyLocationEnabled(true);


        map.setOnMyLocationChangeListener(new GoogleMap.OnMyLocationChangeListener() {
            @Override
            public void onMyLocationChange(Location location) {
                map.addMarker(new MarkerOptions().position(new LatLng(
                        location.getLatitude(), location.getLongitude())).title("You are here!"));

                start = new LatLng(location.getLatitude(), location.getLongitude());
                end = new LatLng(44.48861858, 11.36779726);

                Routing routing = new Routing(Routing.TravelMode.WALKING);
                routing.registerListener(MyActivity.this);
                routing.execute(start, end);
            }
        });