for (KmlPlacemark placemark: layer.getPlacemarks()) {

   if (placemark instanceof KmlPoint) {
     KmlPoint point = (KmlPoint) placemark;
     LatLng latLng = point.getGeometryObject();

     // https://github.com/googlemaps/android-maps-utils/tree/master/library/src/com/google/maps/android/kml

   }       
}