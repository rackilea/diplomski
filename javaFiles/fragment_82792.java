public class AlarmReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        Intent background = new Intent(context, NewsServiceReceiver.class);
        context.startService(background);
    }

}