public class CustomView extends View {

    private static final String TAG = "CustomViewTAG_";

    public CustomView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onAttachedToWindow() {
        super.onAttachedToWindow();
        Log.d(TAG, "This will get called everytime your CustomView gets attached");
    }
}