public class UpdateWidgetService extends Service {
    public UpdateWidgetService() {
    }
    public static final String SKIP = "skip";
    public static final String OPENAPP = "openapp";

    @Override
    public int onStartCommand(Intent pIntent, int flags, int startId) {

        String command = pIntent.getAction();

        int appWidgetId = pIntent.getExtras().getInt(AppWidgetManager.EXTRA_APPWIDGET_ID);
        RemoteViews remoteView = new RemoteViews(getApplicationContext().getPackageName(), R.layout.widget);
        AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(getApplicationContext());

            if(command.equals(SKIP)){
                /**Do the SKIP click work here*/
                return START_NOT_STICKY;
            }else if(command.equals(OPENAPP)){
             /**Do the OPENAPP click work here*/
                Intent mAct=new Intent(this, OPENAPP.class);
                mAct.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                startActivity(mAct);
                return START_NOT_STICKY;
            }

            remoteView.setTextViewText(R.id.widet_ibtn_skip, "MyTextHere");
            remoteView.setTextViewText(R.id.widget_tv_title, "Title");

            remoteView.setOnClickPendingIntent(R.id.widet_ibtn_skip,WallWidgetProvider.makeControlPendingIntent(getApplicationContext(),SKIP,appWidgetId));
            remoteView.setOnClickPendingIntent(R.id.widget_tv_title,WallWidgetProvider.makeControlPendingIntent(getApplicationContext(),OPENAPP,appWidgetId));

            appWidgetManager.updateAppWidget(appWidgetId, remoteView);


        return super.onStartCommand(pIntent, flags, startId);
    }


    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        throw new UnsupportedOperationException("Not yet implemented");
    }
}