int viewportWidth = mMapView.getWidth();
int viewportHeight = mMapView.getHeight();

LatLng topLeft = mMapView.fromScreenLocation(new PointF(0, 0));
LatLng topRight = mMapView.fromScreenLocation(new PointF(viewportWidth, 0));
LatLng bottomRight = mMapView.fromScreenLocation(new PointF(viewportWidth, viewportHeight));
LatLng bottomLeft = mMapView.fromScreenLocation(new PointF(0, viewportHeight));