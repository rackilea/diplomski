for (Map polyline : listaPolylines) {
    List<LatLng> decoded = PolyUtil.decode(polyline.get("points"));

    // Do something with your decoded polyline. For example drawing it on your map
    mMap.addPolyline(new PolylineOptions().addAll(decoded));
}