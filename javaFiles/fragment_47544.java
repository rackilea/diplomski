public void launchActivities(View v) {
    AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

    Intent startChrome = getPackageManager().getLaunchIntentForPackage("com.android.chrome");
    PendingIntent pi1 = PendingIntent.getActivity(getApplicationContext(), 666, startChrome, 0);
    alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 500, pi1);

    Intent startSettings = getPackageManager().getLaunchIntentForPackage("com.android.settings");
    PendingIntent pi2 = PendingIntent.getActivity(getApplicationContext(), 667, startSettings, 0);
    alarmManager.set(AlarmManager.RTC, System.currentTimeMillis() + 1000, pi2);

    finish();
}