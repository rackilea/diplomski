for (int i=0; i<points.size()-1; i++) {
        LatLng currentPoint = points.get(i);
        LatLng nextPoint = points.get(i+1);
        map.addPolyline(new PolylineOptions().add(currentPoint, nextPoint)).
                width(5).color(Color.BLUE);
    }