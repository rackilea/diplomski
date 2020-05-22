/**
 * Fake Hardware {@link AppCompatButton}
 * @see <a href="https://developer.android.com/reference/android/view/KeyEvent">KeyEvent</a>
 * @author Martin Zeitler
 * @version 1.0.0
**/
public class FakeHardwareButton extends AppCompatButton {

    private BaseInputConnection  mInputConnection;

    private int keyCode = KeyEvent.KEYCODE_9;
    private KeyEvent keyDown;
    private KeyEvent keyUp;

    public FakeHardwareButton(Context context) {
        this(context, null);
    }

    public FakeHardwareButton(Context context, AttributeSet attrs) {
        this(context, attrs, 0);
    }

    public FakeHardwareButton(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @SuppressLint("ClickableViewAccessibility")
    private void setupInputConnection(View targetView) {

       this.mInputConnection = new BaseInputConnection(targetView, true);
       this.keyDown = new KeyEvent(KeyEvent.ACTION_DOWN, this.keyCode);
       this.keyUp = new KeyEvent(KeyEvent.ACTION_UP, this.keyCode);

       this.setOnTouchListener(new View.OnTouchListener() {

            @Override
            public boolean onTouch(View v, MotionEvent event) {
                switch(event.getAction()) {
                    case MotionEvent.ACTION_DOWN:
                        mInputConnection.sendKeyEvent(keyDown);
                        return true;

                    case MotionEvent.ACTION_UP:
                        mInputConnection.sendKeyEvent(keyUp);
                        return true;
                }
                return false;
            }
        });
    }
}