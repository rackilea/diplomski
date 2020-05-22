mButtonUndo.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

            // create variable for the 2nd last point clicked and assign value form markerPoints array list
            LatLng lastPoint;
            lastPoint = markerPoints.get(markerPoints.size() - 2);

            // animate camera to centre on the previously touched position
            System.out.println("Centering camera to previous position at " + lastPoint.toString());
            mMap.animateCamera(CameraUpdateFactory.newLatLng(lastPoint));


            // remove polyline object from the map
            for (Polyline line : polylines) {
                if (polylines.get(polylines.size() - 1).equals(line)) {
                    line.remove();
                    polylines.remove(line);
                }
            }

            // remove last value from the markerPoints array list
            markerPoints.remove(markerPoints.size() - 1);

            // update the distance text
            double routeDistance = 0;
            distanceCount.remove(distanceCount.size() - 1);
            for (Double step : distanceCount) {
                routeDistance += step;
            }

            System.out.println("Total Distance calculated in undo in m = " + routeDistance);
            // output new value to ui
            mDistanceCount.setText(routeDistance / 1000 + "km");
        }
    });