public void onReceive(Context context, Intent intent) {

    if(intent.getAction() != null && intent.getAction().equals("myUpdate")) {
        RemoteViews controles = new RemoteViews(context.getPackageName(), R.layout.ferrix_widget);

        String alumnoName = intent.getStringExtra("Name"); //Gets the intent withthe key "Name"
        int id = intent.getIntExtra(
                AppWidgetManager.EXTRA_APPWIDGET_ID,
                AppWidgetManager.INVALID_APPWIDGET_ID);


        System.out.println("[INFO] Key: Name gets result: " + alumnoName);


        controles.setTextViewText(R.id.alumnoName, alumnoName);
        controles.setTextViewText(R.id.claseName, "DAM2");
        AppWidgetManager.getInstance(context).updateAppWidget(id, controles);

        System.out.println("[INFO] Context: " + context);
        System.out.println("[INFO] Received: " + intent.getAction().toString());
    } else {
        super.onReceive(context, intent);
    }
}