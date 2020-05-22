@Override
public void onServiceConnected() {
    AccessibilityServiceInfo config = new AccessibilityServiceInfo();
    config.eventTypes = AccessibilityEvent.TYPE_WINDOWS_CHANGED;
    config.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;

    config.flags = AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS;

    setServiceInfo(config);
    super.onServiceConnected();
}