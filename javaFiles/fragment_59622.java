public void onRestoreInstanceState(Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);

    // Restore your number of points and store them in your variable
    pointCount = savedInstanceState.getInt(POINTS);
}