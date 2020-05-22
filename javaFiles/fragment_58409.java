public boolean onKeyDown(int keyCode, KeyEvent event, View view) {if ((keyCode == KeyEvent.KEYCODE_BACK)) {
// hide keyboard here
InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
imm.hideSoftInputFromWindow(view.getWindowToken(), 0);}

switch (keyCode) {
    case 4:
        if (event.getRepeatCount() == 0 && this.mInputView != null && this.mInputView.handleBack()) {
            return PROCESS_HARD_KEYS;
        }
    case 66:
        return false;
    case 67:
        if (this.mComposing.length() > 0) {
            onKey(-5, null);
            return PROCESS_HARD_KEYS;
        }
        break;
    default:
        if (keyCode == 62 && (event.getMetaState() & 2) != 0) {
            InputConnection ic = getCurrentInputConnection();
            if (ic != null) {
                ic.clearMetaKeyStates(2);
                keyDownUp(29);
                keyDownUp(42);
                keyDownUp(32);
                keyDownUp(46);
                keyDownUp(43);
                keyDownUp(37);
                keyDownUp(32);
                return PROCESS_HARD_KEYS;
            }
        }
        if (this.mPredictionOn && translateKeyDown(keyCode, event)) {
            return PROCESS_HARD_KEYS;
        }
}
return super.onKeyDown(keyCode, event);