relativeParams.addRule(RelativeLayout.BELOW, timeSlots[startTimeHour + 1]);
    relativeParams.setMargins(0, startTimeMin-3, 0, 0);
    newActivity.setLayoutParams(relativeParams);
    // Add to the screen
    RelativeLayout schedule = (RelativeLayout) findViewById(R.id.scheduleView);
    schedule.addView(newActivity);