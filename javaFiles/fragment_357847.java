public class MyApplicationName extends Application implements BootstrapNotifier {
private static final String TAG = ".MyApplicationName";
private RegionBootstrap regionBootstrap;

@Override
public void onCreate() {
    super.onCreate();
    Log.d(TAG, "App started up");
    BeaconManager beaconManager = 
    BeaconManager.getInstanceForApplication(this);


}

@Override
public void didDetermineStateForRegion(int arg0, Region arg1) {
    // Don't care
}

@Override
public void didEnterRegion(Region arg0) {

    regionBootstrap.disable();
    Intent intent = new Intent(this, MainActivity.class);
    // IMPORTANT: in the AndroidManifest.xml definition of this activity, you must set android:launchMode="singleInstance" or you will get two instances
    // created when a user launches the activity manually and it gets launched from here.
    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    this.startActivity(intent);
}

@Override
public void didExitRegion(Region arg0) {

  }        
}