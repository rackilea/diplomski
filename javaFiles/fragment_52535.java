public class NetworkChangeReceiver extends BroadcastReceiver {

private Context context;

@Override
public void onReceive(final Context context, final Intent intent) {
        this.context = context;

        if (isOnline()) {
            // if the internet is working, start the main activity or any activity you want
            Intent i = new Intent(context, MainActivity.class);
            context.startService(i);
        }
    }

    private boolean isOnline() {
        ConnectivityManager cm = (ConnectivityManager) context
                .getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null
                && cm.getActiveNetworkInfo().isConnectedOrConnecting();
    }
}