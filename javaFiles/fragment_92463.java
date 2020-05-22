public class AlarmReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // any action you want to perform will come here
        Toast.makeText(context, "I'm running", Toast.LENGTH_SHORT).show();
    }
}