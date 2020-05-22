PolylineOptions p = new PolylineOptions();
p.color(Color.BLUE);
p.width((float) 7.0);
p.add(actualLocation);
LatLng previousPoint = latLngs.get(latLngs.size() - 2);
p.add(previousPoint);
Polyline polyLine = mMap.addPolyline(p);
this.polyLines.add(polyLine);