String []coordinates = new String[4];
coordinates[0] = "33.477863"; coordinates[1] = "-101.855166"; //Just in-case user didn't choose a city 

if(CityActivity.value.equals("Austin")) { //This 'value' is recived from CityActivity. Depending on what city user chooses.
    coordinates[0] = "30.260053"; coordinates[1] = "-97.738593"; }
else if(CityActivity.value.equals("Dallas")) {
    coordinates[0] = "33.554519"; coordinates[1] = "-101.855621"; }
else if(CityActivity.value.equals("Slaton")) {
    coordinates[0] = "33.577863"; coordinates[1] = "-101.855166"; }


double lat = Double.parseDouble(coordinates[0]);
double lng = Double.parseDouble(coordinates[1]);

p = new GeoPoint(
    (int) (lat * 1E6), 
    (int) (lng * 1E6));


mc = mapView.getController();
mc.animateTo(p);
mc.setZoom(16); 
mapView.invalidate();

MapOverlay mapOverlay = new MapOverlay();
List<Overlay> listOfOverlays = mapView.getOverlays();
listOfOverlays.clear();
listOfOverlays.add(mapOverlay);     
mapView.invalidate();