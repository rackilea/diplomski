public class MainActivity extends Activity {
    Intent mServiceIntent;
...
@Override
protected void onStop() {
    super.onStop();
    mServiceIntent = new Intent(this, Scan.class);
    this.startService(mServiceIntent);
    Log.v("MainActivity", "onStop called");