import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;

public class ConnectionBroadReceiver extends BroadcastReceiver {
   private NetworkCallback callback;

    public ConnectionBroadReceiver(NetworkCallback callback){
          this.callback = callback;
    }

    @Override
    public void onReceive(Context context, Intent intent) {

        ConnectivityManager cm = (ConnectivityManager)
                context.getSystemService(Context.CONNECTIVITY_SERVICE);

        NetworkInfo netInfo = cm.getActiveNetworkInfo();

        if (netInfo != null && netInfo.isConnectedOrConnecting()) {
            callback.onStateChange();
        } else {
             callback.onStateChange();
        }    
    }
}