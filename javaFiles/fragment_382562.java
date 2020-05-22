onResponse( ... ) {
    ...
    String lng = String.valueOf(longiString);

    MarkerOptions opts = createMarker(d, d2, plate_num);
    Marker m = mMapFragment.addMarker(opts);
    list.add(m);
}