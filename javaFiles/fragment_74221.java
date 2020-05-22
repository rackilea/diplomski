public static void hideSoftKeyboard(Context context) {
    try {
        InputMethodManager inputMethodManager = (InputMethodManager) context.getSystemService(Activity.INPUT_METHOD_SERVICE);
        inputMethodManager.hideSoftInputFromWindow(((Activity) context).getWindow().getDecorView().getRootView().getWindowToken(), 0);
        ((Activity) context).getWindow().getDecorView().getRootView().clearFocus();
    } catch (NullPointerException e) {
        // some error log 
    }
}