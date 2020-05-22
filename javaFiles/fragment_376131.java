Marker poleMarker = new Marker(markerPoint,myBitmap),0,0) {
    @Override
    public boolean onTap(org.mapsforge.core.model.LatLong tapLatLong, Point layerXY, Point tapXY) 
    {
         lastTappedMarker = this;
    }
}