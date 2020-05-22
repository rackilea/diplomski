/* (non-Javadoc)
 * @see android.app.Activity#onKeyDown(int, android.view.KeyEvent)
 */
@Override
public boolean onKeyDown(int keyCode, KeyEvent event) {
    if ( keyCode == KeyEvent.KEYCODE_MENU ) {
        Log.d(TAG, "MENU pressed");
        return true;
    }
    return super.onKeyDown(keyCode, event);
}