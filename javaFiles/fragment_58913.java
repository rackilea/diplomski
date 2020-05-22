PolylineOptions p = new PolylineOptions();
p.color(Color.BLUE);
p.width((float) 7.0);
Polyline polyLine = this.mMap.addPolyline(p); // Add before location set
p.add(actualLocation);
LatLng previousPoint = latLngs.get(latLngs.size() - 2);
p.add(previousPoint);
this.polyLines.add(polyLine);
mMap.addPolyline(p); // Add after location set