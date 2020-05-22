AlarmManager mgr = (AlarmManager) context
            .getSystemService(Context.ALARM_SERVICE);
Intent notificationIntent = new Intent(context,
                BudgetAlarm.class);
PendingIntent pi = null;
if (bm.getReminderNotify().equals("Y")
            && currentMonthExpense > budget) {
    Calendar calendar = Calendar.getInstance();
    calendar.setTimeInMillis(System.currentTimeMillis());
    calendar.set(Calendar.HOUR_OF_DAY, 0);
    calendar.set(Calendar.MINUTE, 1);
    notificationCount = notificationCount + 1;
    notificationIntent.putExtra("NotifyCount", notificationCount);
    pi= PendingIntent.getBroadcast(context, 1,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
    mgr.setInexactRepeating(AlarmManager.RTC_WAKEUP,
                calendar.getTimeInMillis(), 60000, pi);
    } else {
        pi= PendingIntent.getBroadcast(context, 1,
                notificationIntent, PendingIntent.FLAG_UPDATE_CURRENT);
        mgr.cancel(pi);
    }