long firstPart = dpiInFloat >> 8;
if (GlobalState.debugModeOn) {
    Log.d(TAG, "First Part: " + firstPart);
}
long lastPart = dpiInFloat & 0xff;
if (GlobalState.debugModeOn) {
    Log.d(TAG, "Last Part: " + lastPart);
}