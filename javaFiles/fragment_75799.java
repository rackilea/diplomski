private LatLngBounds getPolygonBounds(ArrayList<LatLng> polygonPointsList){
    LatLngBounds.Builder builder = new LatLngBounds.Builder();
    for(int i = 0 ; i < polygonPointsList.size() ; i++) {
        builder.include(polygonPointsList.get(i));
    }
    return builder.build();
}