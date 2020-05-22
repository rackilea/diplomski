@SuppressLint("NewApi")
public void tintBackground() {
    View rootView = findViewById(android.R.id.content);
    ColorDrawable[] color = { new ColorDrawable(Color.RED),
            new ColorDrawable(Color.WHITE) };
    TransitionDrawable trans = new TransitionDrawable(color);
    int sdk = android.os.Build.VERSION.SDK_INT;
    if (sdk < android.os.Build.VERSION_CODES.JELLY_BEAN) {
        rootView.setBackgroundDrawable(trans);
    } else {
        rootView.setBackground(trans);
    }
    trans.startTransition(2000); // do transition over 2 seconds

}