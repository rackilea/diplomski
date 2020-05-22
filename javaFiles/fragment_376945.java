@Override
public void onMapReady(GoogleMap googleMap) {
        GMapV2Direction md = new GMapV2Direction();
        Document doc = md.getDocument(formatAddress(ORIGIN_TEXT, formatAddress(DESTINATION_TEXT, MODE, getApplicationContext());
        if (doc != null) {

            int duration = md.getDurationValue(doc);

            if (duration > 0) {
                try {

                    ArrayList<LatLng> directionPoint = md.getDirection(doc);
                    PolylineOptions rectLine = new PolylineOptions().width(9).color(R.color.splash_blue).geodesic(true);

                    for (int i = 0; i < directionPoint.size(); i++) {
                        rectLine.add(directionPoint.get(i));
                    }

                    AccessLocationActivity.this.mMap.addPolyline(rectLine);
                } catch (Exception e) {
                    e.printStackTrace();
                }

        }