private MapGesture.OnGestureListener yourGestureHandlerImpementation = new MapGesture.OnGestureListener.OnGestureListenerAdapter()
{
    @Override
    public boolean onLongPressEvent(PointF p) {
            GeoCoordinate c = map.pixelToGeo(p);
            // c is your geoccordinate on the map, where you clicked on the screen
            // [...]
    }
}