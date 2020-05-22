import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.util.Log;

public class ScreenOnOffReceiver extends BroadcastReceiver {

private final static String SCREEN_TOGGLE_TAG = "SCREEN_TOGGLE_TAG";

@Override
public void onReceive(Context context, Intent intent) {
    String action = intent.getAction();
    if(Intent.ACTION_SCREEN_OFF.equals(action))
    {
        Log.d(SCREEN_TOGGLE_TAG, "Screen is turn off.");
    }else if(Intent.ACTION_SCREEN_ON.equals(action))
    {
        Log.d(SCREEN_TOGGLE_TAG, "Screen is turn on.");
    }}
}