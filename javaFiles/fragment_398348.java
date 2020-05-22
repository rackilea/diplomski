Intent intent = new Intent(this, NewAppWidget.class);
intent.setAction(AppWidgetManager.ACTION_APPWIDGET_UPDATE);

int[] ids = AppWidgetManager.getInstance(getApplication()).getAppWidgetIds(new ComponentName(getApplication(), NewAppWidget.class));

intent.putExtra(AppWidgetManager.EXTRA_APPWIDGET_IDS, ids);
sendBroadcast(intent);