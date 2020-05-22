private void udpateWidgets() {
    Intent intent = new Intent(this, IoTUpdatingChartWidget.class);
    intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);
     int[] ids = AppWidgetManager.getInstance(getApplication())
        .getAppWidgetI‌​ds(new ComponentName(getApplication(), IoTUpdatingChartWidget.class));
    intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
    sendBroadcast(intent);
}