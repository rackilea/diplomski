public class EditTextPlus extends AppCompatEditText {
    //This is the custom listener you will use
    public OnFocusChangeListener customListener;

    @Override
    protected void onFocusChanged(boolean focused, int direction, Rect previouslyFocusedRect) {
        super.onFocusChanged(focused, direction, previouslyFocusedRect);
        if (customListener != null) {
            customListener.onFocusChange(this, focused);
        }
    }
}