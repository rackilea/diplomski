private void drawpolygon(DistanceInfo  array[]) {

    int length = array.length;

    // Optional length checks. Modify yourself.
    if(length == 0) 
    {
       // Do whatever you like then get out. Do not run the following.
       return;
    }

    // We have a length of not 0 so...    
    PolygonOptions poly = new PolygonOptions();
    poly.fillColor(Color.GRAY);

    // Initial point
    poly.add(new LatLng(9.6632139, 80.0133258);

    // ... then the rest.
    for(int i = 0; i < length; i++)
    {
        poly.add(new LatLng(array[i].a, array[i].b));
    }

    // Done! Add to map.
    mMap.addPolygon(poly);
}