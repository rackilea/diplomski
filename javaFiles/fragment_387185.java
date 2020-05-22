imageView.setAccessibilityDelegate(new View.AccessibilityDelegate() {
    @Override
    public void onPopulateAccessibilityEvent(View host, AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(host, event);

        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED) {
            Log.v(TAG, "Populating accessibility event");
            event.getText().add("Custom text from AccessibilityDelegate");
        }
    }
});