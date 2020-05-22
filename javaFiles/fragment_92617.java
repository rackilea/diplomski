public class GpsMiniActivity extends Activity {

private LocationManager mLocMgr;
private TextView tv1;
@Override
public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    FrameLayout rl = new FrameLayout(this.getApplicationContext());
    LinearLayout ll= new LinearLayout(this.getApplicationContext());
    ll.setOrientation(LinearLayout.VERTICAL);

    setContentView(rl);
    rl.addView(ll);

    tv1=new TextView(getApplicationContext());
    ll.addView(tv1);

    //setContentView(R.layout.main);
    mLocMgr = (LocationManager) getSystemService(LOCATION_SERVICE);
    mLocMgr.requestLocationUpdates(LocationManager.GPS_PROVIDER,
            500, 0, ll);
}
}
private LocationListener ll = new LocationListener(){
public void onLocationChanged(Location location) {
    tv1.setText("Lat " +   location.getLatitude() + " Long " + location.getLongitude());
}
public void onProviderDisabled(String provider) {}
public void onProviderEnabled(String provider) {}
public void onStatusChanged(String provider, int status, Bundle extras) {}
}
}