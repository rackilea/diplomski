AlarmManager service = (AlarmManager) this.getSystemService(Context.ALARM_SERVICE);
    Intent i = new Intent(this, AlarmReceiver.class);
    i.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
    PendingIntent pending = PendingIntent.getBroadcast(this, 0, i,PendingIntent.FLAG_CANCEL_CURRENT);
    Calendar cal = Calendar.getInstance();
    // Start 1 month after boot completed
    cal.add(Calendar.MONTH, 1);
    //
    // Fetch every 1 month
    // InexactRepeating allows Android to optimize the energy consumption
    service.setInexactRepeating(AlarmManager.RTC_WAKEUP ,cal.getTimeInMillis(),AlarmManager.INTERVAL_DAY , pending);