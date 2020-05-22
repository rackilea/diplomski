public static final String INTERVAL_COUNT = "INTERVAL_COUNT";

private void startTimeActivity(int numberOfIntervals) {
    Intent intent = new Intent(this, TimeActivity.class);
    intent.putExtra(INTERVAL_COUNT, numberOfIntervals)
    startActivity(intent);
    Log.d(TAG, "startTimeActivity: TimeActivity has been started" + numberOfIntervals);
}