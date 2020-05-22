@Override
public void getMapAsync(OnMapReadyCallback callback) {
    mMapReadyCallback = callback;
    super.getMapAsync(this);
}

@Override
public void onMapReady(MapboxMap mapboxMap) {
    mMapboxMap = mapboxMap;
    if (mMapReadyCallback != null) {
        mMapReadyCallback.onMapReady(mapboxMap);
    }
}