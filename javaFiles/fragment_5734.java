public class CurrentLocation implements Callable<Location> {

  private static final String TAG = "CurrentLocation";
  private Context context;
  private LocationManager lm;
  private Criteria criteria;
  private Location bestResult;
  private boolean locationListenerWorking;


  public CurrentLocation(Context context) {
    lm = (LocationManager)context.getSystemService(Context.LOCATION_SERVICE);
    this.context = context;
    criteria = new Criteria();
    criteria.setAccuracy(Criteria.ACCURACY_FINE);
    bestResult = null;
    locationListenerWorking = false;
  }


  public Location call() {
    return getLoc();
  }


  private Location getLoc() {
    String provider = lm.getBestProvider(criteria, true);
    if (provider != null) {
      Log.d(TAG, "Using provider: " +provider);
      locationListenerWorking = true;
      lm.requestLocationUpdates(provider,
                                0,
                                0,
                                singeUpdateListener,
                                context.getMainLooper());
    } else {
      Log.w(TAG, "Couldn't find a location provider");
      return null;
    }



    while (locationListenerWorking) {
      // Check for the interrupt signal - terminate if necessary
      if (Thread.currentThread().isInterrupted()) {
        Log.i(TAG, "User initiated interrupt (cancel signal)");
        cleanup();
        break;
      }

      try {
        // ghetto implementation of a busy wait...
        Thread.sleep(500); // Sleep for half a second
      } catch (Exception e) {
        Log.d(TAG, "Thread interrupted..");
        cleanup();
        break;
      }
    }

    return bestResult;
  }




  private void cleanup() {
    if (lm != null) {
      Log.d(TAG, "Location manager not null - cleaning up");
      lm.removeUpdates(singeUpdateListener);
    } else {
      Log.d(TAG, "Location manager was NULL - no cleanup necessary");
    }
  }




  /**
   * This one-off {@link LocationListener} simply listens for a single location
   * update before unregistering itself.  The one-off location update is
   * returned via the {@link LocationListener} specified in {@link
   * setChangedLocationListener}.
   */
  private LocationListener singeUpdateListener = new LocationListener() {
      public void onLocationChanged(Location location) {
        Log.d(TAG, "Got a location update");
        if (location == null) {
          Log.d(TAG, "Seems as if we got a null location");
        } else {
          bestResult = location;
        }

        cleanup();
        locationListenerWorking = false;
      }

      public void onStatusChanged(String provider, int status, Bundle extras) {}
      public void onProviderEnabled(String provider) {}    
      public void onProviderDisabled(String provider) {}
    };

}