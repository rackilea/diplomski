_map.setOnCameraIdleListener(new GoogleMap.OnCameraIdleListener() {
    @Override
    public void onCameraIdle() {
        Log.d(Consts.TAGS.FRAG_MAIN_MAP,"Current Zoom : " + _map.getCameraPosition().zoom);
        Log.d(Consts.TAGS.FRAG_MAIN_MAP,"Center Lat : " + _map.getCameraPosition().target.latitude +
                ", Center Long : " + _map.getCameraPosition().target.longitude);

        float zoom = _map.getCameraPosition().zoom;
        LatLng position = _map.getCameraPosition().target;
        double maxRadius = calculateScale(zoom, position) * mapViewDiagonal() / 2;
    }
}

private mapViewDiagonal() {
    return Math.sqrt(_map.getWidth() * _map.getWidth() + _map.getHeight() * _map.getHeight());
}