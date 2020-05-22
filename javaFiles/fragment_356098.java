private void updateWidget() {
    final int percentage = batteryPercentage.get();
    log.i(LOG, "Updated... " + percentage);

    RemoteViews remoteViews = new RemoteViews(getPackageName(),  R.layout.battery_widget_layout);
    remoteViews.setTextViewText(R.id.batteryPercentageWidgetTextView, percentage + "%");

    remoteViews.setInt(R.id.battery, "setImageLevel", percentage * 100);

    AppWidgetManager appWidgetManager = AppWidgetManager.getInstance(this);
    appWidgetManager.updateAppWidget(new ComponentName(this, BatteryAppWidgetProvider.class), remoteViews);
}