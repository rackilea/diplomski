public class CustomSpinner extends Spinner {

    private boolean mToggleFlag = true;

    public CustomSpinner(Context context, AttributeSet attrs, int defStyle, int mode) {
        super(context, attrs, defStyle, mode);
    }

    public CustomSpinner(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public CustomSpinner(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CustomSpinner(Context context, int mode) {
        super(context, mode);
    }

    public CustomSpinner(Context context) {
        super(context);
    }

    @Override
    public int getSelectedItemPosition() {
        if (!mToggleFlag) {
            return 0; // Gets to the first element
        }
        return super.getSelectedItemPosition();
    }

    @Override
    public boolean performClick() {
        mToggleFlag = false;
        boolean result = super.performClick();
        mToggleFlag = true;
        return result;
    }

}