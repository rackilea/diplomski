public class BatteryReceiver extends BroadcastReceiver {

@Override
public void onReceive(Context context, Intent intent) {

    int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
    if (level < 10) {
        // Write your code here
    }
}

}