for (int i = 0; i < yourArrayList.size(); i++) {

  double lati=Double.parseDouble(pins.get(i).latitude);
  double longLat=Double.parseDouble(pins.get(i).longitude);
  MAP.addMarker(new MarkerOptions().position(new LatLng(lati,longLat)).title(pins.get(i).pinname).snippet(pins.get(i).address));
 }