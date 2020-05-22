public void geoLocate(View view){

        String start = start_address.getText().toString();
        String destination = destination_address.getText().toString();

        Geocoder gc = new Geocoder(getActivity());
        try {

            List<android.location.Address> list = gc.getFromLocationName(start,1);
            final Address adress1 =  list.get(0);
            String  start_adress = adress1.getLocality();
            double lat_start = adress1.getLatitude();
            double lng_start = adress1.getLongitude();


            list = gc.getFromLocationName(destination,1);
            Address adress2 =  list.get(0);
            String  destination_adress = adress2.getLocality();
            double lat_destination = adress2.getLatitude();
            double lng_destination = adress2.getLongitude();

            if (start_marker != null || destination_marker != null){
                start_marker.remove();
                destination_marker.remove();
            }

            options_start = new MarkerOptions()
                    .title(start_adress)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN))
                    .position(new LatLng(lat_start, lng_start));
            start_marker = mGoogleMap.addMarker(options_start);
            options_destination = new MarkerOptions()
                    .title(destination_adress)
                    .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_BLUE))
                    .position(new LatLng(lat_destination, lng_destination));
            destination_marker = mGoogleMap.addMarker(options_destination);
            reservation.setClickable(true);
            reservation.setEnabled(true);
            reservation.setTextColor(getResources().getColor(R.color.white));
            reservation.setBackgroundColor(getResources().getColor(R.color.colorPrimary));
            if(reservation.isClickable()) {
                reservation.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    }
                });
            }

            LatLngBounds.Builder builder = new LatLngBounds.Builder();
            builder.include(start_marker.getPosition());
            builder.include(destination_marker.getPosition());
            LatLngBounds bounds = builder.build();
            final StringBuilder url = new StringBuilder("http://maps.googleapis.com/maps/api/directions/json?sensor=false&language=fr");
            url.append("&origin=");
            url.append(start.replace(" ", "+"));
            url.append("&destination=");
            url.append(destination.replace(" ", "+"));


            GMapV2Direction md = new GMapV2Direction();
            Document doc = md.getDocument(formatAddress(start), formatAddress(destination), GMapV2Direction.MODE_DRIVING, getApplicationContext());
            if (doc != null) {

                int duration = md.getDurationValue(doc);

                if (duration > 0) {
                    try {

                        ArrayList<LatLng> directionPoint = md.getDirection(doc);
                        PolylineOptions rectLine = new PolylineOptions().width(9).color(R.color.colorPrimary).geodesic(true);

                        for (int i = 0; i < directionPoint.size(); i++) {
                            rectLine.add(directionPoint.get(i));
                        }

                        mGoogleMap.addPolyline(rectLine);
                    } catch (Exception e) {
                        e.printStackTrace();
                    }


        } catch (IOException e) {
            e.printStackTrace();
        }

    }