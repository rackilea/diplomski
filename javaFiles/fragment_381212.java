public class TouchEventView extends LinearLayout {

    public TouchEventView(Context context) {
        this(context, null);
    }

    public TouchEventView(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public TouchEventView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        Button button = new Button(getContext());
        button.setLayoutParams(new LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT));
        addView(button);
    }

}