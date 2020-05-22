List<String> a = db.getID();
    googleMap.clear();
        for (int i = 0; i < a.size(); i++) {

            String id = a.get(i);

            List<String> latllng = db.getLatLng(id);
            latllng.toString();
            String[] Latlng = latllng.toString().replace("[", "")
                    .replace("]", "").split(",");
            double latitude = Double.parseDouble(Latlng[0]);
            double longitude = Double.parseDouble(Latlng[1]);
            // googleMap.clear(); <<< comment out this code else all of your previous marker get cleared

            if (marker == null)
                pos = new LatLng(latitude, longitude);
             // googleMap.moveCamera(CameraUpdateFactory.newLatLngZoom(pos, 17)); << you can not move map for each and every marker you are adding
            marker = googleMap.addMarker(new MarkerOptions().position(pos));
            marker.setIcon(BitmapDescriptorFactory
                    .fromResource(R.drawable.my_marker));
            marker.setTitle(id);
            pos = new LatLng(latitude, longitude);
            animateMarker(marker, pos, hideMarker); 

        }