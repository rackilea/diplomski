Tracker t = null;
if (trackerId == TrackerName.APP_TRACKER) {
    t = analytics.newTracker(PROPERTY_ID);
} else if ((trackerId == TrackerName.GLOBAL_TRACKER)) {
    t = analytics.newTracker(R.xml.global_tracker);
} else {
    t = analytics.newTracker(R.xml.ecommerce_tracker);
}