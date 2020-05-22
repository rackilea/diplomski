/**
 * Filtered {@link AppCompatEditText}
 * @author Martin Zeitler
 * @version 1.0.0
**/
public class FilteredEditText extends AppCompatEditText {

    private static final String LOG_TAG = FilteredEditText.class.getSimpleName();

    private String expectedString = null;

    public FilteredEditText(Context context) {
        super(context);
    }

    public FilteredEditText(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public FilteredEditText(Context context, AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    public void setExpectedString(@NonNull String value) {
        this.expectedString = value;
        this.setupInputFilter();
    }

    public void setupInputFilter() {
        this.setFilters(new InputFilter[] {
            new InputFilter() {
                public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int destStart, int destEnd) {
                    if (source.length() > 0 && source.charAt(end-1) == expectedString.charAt(destEnd)) {

                        /* valid input received */
                        Log.d(LOG_TAG, "input accepted: " + String.valueOf(source.charAt(end-1)));
                        return source;

                    } else {

                        /* invalid input received */
                        Log.d(LOG_TAG, "input rejected: " + String.valueOf(source.charAt(end-1)) + " - expected: " + String.valueOf(expectedString.charAt(destEnd)));
                        return "";
                    }
                }
            }
        });
    }

    /** hardware event  */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        Log.d(LOG_TAG, "onKeyDown()");
        return super.onKeyDown(keyCode, event);
    }

    /** hardware event  */
    @Override
    public boolean onKeyUp(int keyCode, KeyEvent event) {
        Log.d(LOG_TAG, "onKeyUp()");
        return super.onKeyUp(keyCode, event);
    }
}