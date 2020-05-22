/**
 * To hide a keypad.
 *
 * @param context
 * @param view
 */
public static void hideKeyboard(Context context, View view) {
    if ((context == null) || (view == null)) {
        return;
    }
    InputMethodManager mgr =
            (InputMethodManager) context.getSystemService(Context.INPUT_METHOD_SERVICE);
    mgr.hideSoftInputFromWindow(view.getWindowToken(), 0);
}