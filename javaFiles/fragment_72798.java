public class SCS extends Activity {
private Handler handler;
private Runnable runnable;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_connection_stablizer);
}
public static void methodName(Context context) {
    // TODO Auto-generated method stub
    CheckConnection();
}

private void CheckConnection() {
    ConnectivityManager cn = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
    NetworkInfo nf = cn.getActiveNetworkInfo();
    if (nf != null && nf.isConnected() == true) {
        CheckAccess();
        Toast.makeText(this,
                "Network Available! now checking Inernet access..",
                Toast.LENGTH_SHORT).show();
    } else {
        // Toast.makeText(this, "Network Not Available", Toast.LENGTH_SHORT)
        // .show();
    }
}

class SCSReceiver extends BroadcastReceiver {

@Override
public void onReceive(Context context, Intent intent) {
    methodName(context);
    // ... do what you need to do here...
}

}