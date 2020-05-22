AccessibilityServiceInfo config = new AccessibilityServiceInfo();
config.eventTypes = AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED;
config.feedbackType = AccessibilityServiceInfo.FEEDBACK_GENERIC;
config.notificationTimeout = 100;

if (Build.VERSION.SDK_INT >= 16) {
  //Just in case this helps
  config.flags = AccessibilityServiceInfo.FLAG_INCLUDE_NOT_IMPORTANT_VIEWS;
}
setServiceInfo(config);