@Override
protected void onStart() {
    super.onStart();
    SharedPreferences sPrefs = getSharedPreferences("sharedPreferences", MODE_PRIVATE);

    if(1>0){            
        timesLeft = sPrefs.getLong("timeleft", 0);
        long stopTime = sPrefs.getLong("sysstoptime", 0);
        long currentTime = System.currentTimeMillis();
        timee = timesLeft - (currentTime - stopTime);
        startTimer();
    }
    else {
        Toast t5 = Toast.makeText(this, "less than or equal 0", Toast.LENGTH_LONG);
        t5.show();
    }
}