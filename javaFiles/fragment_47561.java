public CustomAdapter(Context context, ArrayList<Integer> mWorkTW, ArrayList<Integer> mWorkET, ArrayList<Integer> mRestTW, ArrayList<Integer> mRestET, int numberOfIntervals) {
    this.mWorkTW = mWorkTW;
    // ...
    this.numberOfIntervals = numberOfIntervals;
    Log.d(TAG, "CustomAdapter: " + numberOfIntervals);
}