@Override
public void onAccessibilityEvent(AccessibilityEvent event) {
  try { // Try to avoid Security exceptions (Seen in Play Console)
    if (event.getEventType() == AccessibilityEvent.TYPE_WINDOW_STATE_CHANGED) {
      if (event.getPackageName() != null && event.getClassName() != null) {
        ComponentName componentName = new ComponentName(
          event.getPackageName().toString(),
          event.getClassName().toString()
        );
        // check componentName and do what you want
      }
    }
  }
}