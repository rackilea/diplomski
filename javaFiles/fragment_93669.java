public class ScheduleDeleteReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        (new ScheduleDelete(){}).deleteOldEntries();
    }
}