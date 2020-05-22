for (int i = 0; i < results.length(); i++ ) {
String name = placeList.get(i).getName();
double lat = placeList.get(i).getLat();
double lng = placeList.get(i).getLng();
map.addMarker(new CustomMarkerOptions()
        .position(new LatLng(lat, lng))
        .place(place)
        .title());
}

// CustomOnMarkerClickListener(place) implements GoogleMap.OnMarkerClickListener
map.setOnMarkerClickListener(new CustomOnMarkerClickListener());