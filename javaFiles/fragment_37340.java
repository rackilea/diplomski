public class NetworkChangeReceiver extends BroadcastReceiver {

@Override
public void onReceive(final Context context, final Intent intent) {

    String status = NetworkUtil.getConnectivityStatusString(context);

    Toast.makeText(context, status, Toast.LENGTH_LONG).show();
}
 }