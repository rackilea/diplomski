final LocationEngine locationEngine = new LostLocationEngine(this);
locationEngine.setPriority(LocationEnginePriority.HIGH_ACCURACY);
locationEngine.addLocationEngineListener(new LocationEngineListener() {
  @Override
  public void onConnected() {
    locationEngine.requestLocationUpdates();
  }

  @Override
  public void onLocationChanged(Location location) {

  }
});
locationEngine.activate();