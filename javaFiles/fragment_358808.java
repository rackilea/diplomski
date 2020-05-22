class MainMenu {
  private final Context appContext;
  private final BeaconManager manager;

  public MainMenu(@NotNull Context context) {
    appContext = context.getApplicationContext();
    manager = BeaconManager.getBeaconManager(context);
  }

  public void connectBeacon(@NotNull Callback callback) {
    beaconManager.connect(new BeaconManager.ServiceReadyCallback() {
      @Override
      public void onServiceReady() {
        beaconManager.startRanging(region);
        callback.onSuccess(region);
      }
    });
  }

  public void disconnectBeacon(@NotNull Region region) {
    if (manager.isRanging(region)) {
      beaconManager.stopRanging(region);
    }
  }
}