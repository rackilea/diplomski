public void onModuleLoad() {
    RootPanel.get().add(new GoogleMaps());
}

private class GoogleMaps extends Composite {

    private MapWidget fMap;
    private Geocoder fCoder;
    private Marker fMarker;

    public GoogleMaps() {
        fMap = new MapWidget(LatLng.newInstance(47.0559084, 8.3114878), 6);
        fMap.setSize("300px", "300px");
        fCoder = new Geocoder();
        MarkerOptions options = MarkerOptions.newInstance();
        options.setDraggable(true);
        fMarker = new Marker(LatLng.newInstance(47.0559084, 8.3114878), options);
        fMap.addOverlay(fMarker);
        fMarker.setVisible(false);
        addHandlers();
        initWidget(fMap);
    }

    private void addHandlers() {
        fMap.addMapDoubleClickHandler(new MapDoubleClickHandler() {

            @Override
            public void onDoubleClick(MapDoubleClickEvent event) {
                if (event.getLatLng() != null) {
                    performReverseLookup(event.getLatLng());
                }
            }

        });

        fMarker.addMarkerDragEndHandler(new MarkerDragEndHandler() {

            @Override
            public void onDragEnd(MarkerDragEndEvent event) {
                LatLng point = event.getSender().getLatLng();
                if (point != null) {
                    performReverseLookup(point);
                }
            }

        });
    }

    private void performReverseLookup(final LatLng point) {
        fCoder.getLocations(point, new LocationCallback() {

            @Override
            public void onSuccess(JsArray<Placemark> locations) {
                if (locations.length() > 0) {
                    LatLng point = locations.get(0).getPoint();
                    fMarker.setLatLng(point);
                    fMarker.setVisible(true);
                    fMap.getInfoWindow().open(point, new InfoWindowContent(locations.get(0).getAddress()));
                }
            }

            @Override
            public void onFailure(int statusCode) {}
        });
    }
}