public class MapRun extends FragmentActivity implements LocationListener,
        LocationSource {

   Location startLocation;
   Location endLocation;

   Location currentLocation;


    @Override
    public void onLocationChanged(Location location) {
        if (mListener != null) {
            mListener.onLocationChanged(location);

            // Move the camera to the user's location once it's available!

            mMap.animateCamera(CameraUpdateFactory.newLatLngZoom(new LatLng(
                    location.getLatitude(), location.getLongitude()), 16.0f));
        }
       currentLocation = location;
    }

 public void startRun() {
        startLocation = currentLocation;
    }

    public void stopRun() {
       stopLocation = currentLocation;
    }

 public float getDistance() {
   float distance = 0f;
   if (stopLocation != null && startLocation != null)
       distance = stopLocation.distanceTo(startLocation);
   return distance;
 }

}