protected void onResume() {
        super.onResume();

        if(!prefs.getBoolean(Helper.ALARM_SET, false)) {
            Intent intent = new Intent(this, NewsIntentService.class);
            PendingIntent pi = PendingIntent.getService(this, 0, intent, 0);
            AlarmManager am = (AlarmManager) getSystemService(Context.ALARM_SERVICE);
            am.setRepeating(AlarmManager.RTC, System.currentTimeMillis(),
                    10 * 60 * 1000, pi);

            Log.i(Helper.ALARM_SET, "Alarm is set.");

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean(Helper.ALARM_SET, true);
            editor.commit();
        }   
    }