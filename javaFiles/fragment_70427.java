public class ButtonExtended extends AppCompatButton{
public ButtonExtended(Context context) {
    super(context);
}
public ButtonExtended(Context context, AttributeSet attrs) {
    super(context, attrs);
}
public ButtonExtended(Context context, AttributeSet attrs, int defStyleAttr) {
    super(context, attrs, defStyleAttr);
}
@Override
public boolean performClick() {
    Log.d("Button","performClick");
    return super.performClick();
}
}