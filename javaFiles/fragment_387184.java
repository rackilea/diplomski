public class CustomImageView  extends ImageView {

    private static final String TAG = CustomImageView.class.getSimpleName();

    /* Here are constructors from ImageView */

    @Override
    public void onPopulateAccessibilityEvent(AccessibilityEvent event) {
        super.onPopulateAccessibilityEvent(event);

        if (event.getEventType() == AccessibilityEvent.TYPE_VIEW_CLICKED) {
            Log.v(TAG, "Populating accessibility event");
            event.getText().add("Custom text from onPopulateAccessibilityEvent");
        }
    }
}