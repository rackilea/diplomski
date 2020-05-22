//You're initializing your list "POLILYNES" and trying remove empty list, Remove the 
//lines I commented.

@Override
public void onRoutingSuccess(ArrayList<Route> routeArrayList, int i) {

//code to add route to map here.
 polylines = new ArrayList<>(); // DELETE THIS LINE
 if (polylines.size() > 0) {
     erasePolylines();
 }
     polylines = new ArrayList<>(); // DELETE THIS LINE
     //add route(s) to the map.
 polylines.clear();

    ...
 }