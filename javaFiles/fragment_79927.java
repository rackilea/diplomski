startimerPreferences = getPreferences(MODE_APPEND);

Date startDate = new Date(startimerPreferences.getLong("time", 0));
timerstarted = startDate.getTime();
Log.e("This is the start time!!!!!:  ", timerstarted + "");


endTimerPreferences = getPreferences(MODE_APPEND);
Date endDate = new Date(endTimerPreferences.getLong("time", 0));
timerends = endDate.getTime();
Log.e("This is the end time!!!!!:  ", timerends + "");


Date openagain = new Date(System.currentTimeMillis());
reopened = openagain.getTime();