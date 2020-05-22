public class WallWidgetProvider extends AppWidgetProvider{

    public static final int UPDATE_RATE = 1000;

    @Override
    public void onDeleted(Context context, int[] appWidgetIds) {
        for (int appWidgetId : appWidgetIds) {
            setCounterAlarm(context, appWidgetId, -1);
        }
        super.onDeleted(context, appWidgetIds);
    }

    @Override
    public void onDisabled(Context context) {
        context.stopService(new Intent(context,UpdateWidgetService.class));
        super.onDisabled(context);
    }

    @Override
    public void onUpdate(Context context, AppWidgetManager appWidgetManager, int[] appWidgetIds) {
        PrefrenceSettings ps=new PrefrenceSettings(context);

        for (int appWidgetId : appWidgetIds) {
                setCounterAlarm(context, appWidgetId, UPDATE_RATE);
            }

        super.onUpdate(context, appWidgetManager, appWidgetIds);
    }

    public static void setCounterAlarm(Context context, int appWidgetId, int updateRate) {
        PendingIntent newPending = makeControlPendingIntent(context,UpdateWidgetService.UPDATE,appWidgetId);
        AlarmManager alarms = (AlarmManager) context.getSystemService(Context.ALARM_SERVICE);
        if (updateRate >= 0) {
            alarms.setInexactRepeating(AlarmManager.ELAPSED_REALTIME, SystemClock.elapsedRealtime(), updateRate, newPending);
        } else {
            // on a negative updateRate stop the refreshing
            alarms.cancel(newPending);
        }
    }

    public static PendingIntent makeControlPendingIntent(Context context, String command, int appWidgetId) {
        Intent active = new Intent(context,UpdateWidgetService.class);
        active.setAction(command);
        active.putExtra(AppWidgetManager.EXTRA_APPWIDGET_ID, appWidgetId);
        //this Uri data is to make the PendingIntent unique, so it wont be updated by FLAG_UPDATE_CURRENT
        //so if there are multiple widget instances they wont override each other
        Uri data = Uri.withAppendedPath(Uri.parse("widget://widget/id/#"+command+appWidgetId), String.valueOf(appWidgetId));
        active.setData(data);
        return(PendingIntent.getService(context, 0, active, PendingIntent.FLAG_UPDATE_CURRENT));
    }

}