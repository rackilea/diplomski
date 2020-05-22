// The key for saving and retrieving isActivityRecreated field.
private static final String KEY_IS_ACTIVITY_RECREATED = "KEY_IS_ACTIVITY_RECREATED";

/** true if this activity is recreated. */
private boolean isActivityRecreated = false;

// Call this method when you want to recreate this activity.
private void recreateActivity() {
    isActivityRecreated = true;
    recreate();
}

@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    outState.putBoolean(KEY_IS_ACTIVITY_RECREATED, isActivityRecreated);
    outState.putInt(Constants.VIDEO_ID, videoId);
    outState.putInt(Constants.CATEGORY_ID, categoryId);
}