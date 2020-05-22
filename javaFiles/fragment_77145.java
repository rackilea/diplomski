mMap.setOnCameraChangeListener(new OnCameraChangeListener() {

    private float currentZoom = -1;

    @Override
    public void onCameraChange(CameraPosition pos) {
        if (pos.zoom != currentZoom){
            currentZoom = pos.zoom;
            // do you action here
        }
    }
});