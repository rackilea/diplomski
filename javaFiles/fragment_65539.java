public class DeviceLocationClient implements
    GooglePlayServicesClient.ConnectionCallbacks,
    GooglePlayServicesClient.OnConnectionFailedListener, LocationListener {

  private Context context;
  private LocationClient locationClient;
  private boolean isConnected;
  private LocationRequest request;


  @Override
  public void onLocationChanged(Location location) {
    System.out.println("got a location update");
    if (location != null ) {
      // do something with the location
    }
  }

  public DeviceLocationClient(Context context) {

    this.context = context;
    System.out.println("connecting to google play services");
    locationClient = new LocationClient(context, this, this);
    isConnected = false;
    locationClient.connect();

  }

  @Override
  public void onConnectionFailed(ConnectionResult result) {
    System.out.println("connection to google play services FAILED!");

  }

  @Override
  public void onConnected(Bundle connectionHint) {
    System.out.println("google play servies connected");
    isConnected = true;
    // locationClient.requestLocationUpdates(request, this);
    request = new LocationRequest();
    request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    request.setExpirationDuration(60 * 1000);
    request.setFastestInterval(5 * 1000);
    request.setInterval(10 * 1000);
    isConnected = true;
    requestLLocationUpdates();

  }

  @Override
  public void onDisconnected() {
    // TODO Auto-generated method stub
    System.out
        .println("google play services got disconnected - reconnecting");
    mBus.unregister(this);
    locationClient.connect();

  }

  @Subscribe
  public void onUpdateLocationRequest(UpdateLocationRequest event) {
    System.out.println("got the location request");
    request = new LocationRequest();
    request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
    request.setExpirationDuration(60 * 1000);
    request.setFastestInterval(5 * 1000);
    request.setInterval(10 * 1000);
    locationClient.removeLocationUpdates(this);
    locationClient.requestLocationUpdates(request, this);
  }

  public void requestLLocationUpdates() {
    System.out.println("requesting location updates updates");

    if (isConnected) {
      System.out.println("processing request");
      System.out.println("sending latest location");
      Location lastLocation = locationClient.getLastLocation();
      if (lastLocation != null) {
        // do something with the last location
      }
      request = new LocationRequest();
      request.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
      request.setExpirationDuration(60 * 1000);
      request.setFastestInterval(5 * 1000);
      request.setInterval(10 * 1000);
      System.out.println("requesting updates");
      locationClient.removeLocationUpdates(this);
      locationClient.requestLocationUpdates(request, this);
    } else {
      if (locationClient.isConnecting()) {
        System.out.println("google play services is connecting");
      } else {
        System.out
            .println("attempting to connect to google play services");
        locationClient.connect();
      }

    }
  }

}