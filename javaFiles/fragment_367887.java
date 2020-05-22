MarkerImage mi = MarkerImage.create("http://chart.apis.google.com/chart?chst=d_text_outline&chld=000000|16|h|FFFFFF|_|Example");
MarkerOptions mo = MarkerOptions.create();
mo.setIcon(mi);
mo.setPosition(LatLng.create(37.1918, -95.8892));
Marker m = Marker.create(mo);
m.setMap(map);