package keyboard.rob.com;

import ...

public class TotalKeyboard extends InputMethodService 
implements KeyboardView.OnKeyboardActionListener {

    private LinearLayout mInputView;

    @Override public void onCreate() {
        super.onCreate();
    }

    @Override public View onCreateInputView() {
        mInputView = (LinearLayout) getLayoutInflater().inflate(R.layout.main, null);
        return mInputView;
    }
}