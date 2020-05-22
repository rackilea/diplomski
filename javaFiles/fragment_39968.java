private Boolean initialStart = true;
private Boolean isOpened = false;

...

private void setupListeners() {

    final View activityRootView = getWindow().getDecorView().findViewById(android.R.id.content);
    activityRootView.getViewTreeObserver().addOnGlobalLayoutListener(new ViewTreeObserver.OnGlobalLayoutListener() {
        @Override
        public void onGlobalLayout() {

            int heightDiff = activityRootView.getRootView().getHeight() - activityRootView.getHeight();
            Log.d("KB", "HeightDiff: " + heightDiff);
            if (heightDiff > 100) { // 99% of the time the height diff will be due to a keyboard.

                if (!isOpened && initialStart) {
                    Log.d("KB", "1) openKeyboard");
                    //Do two things, make the view top visible and the editText smaller
                    noteEditText.setLines(15);
                    noteEditText.requestLayout();
                    initialStart = false;
                    isOpened = true;
                } else if (!isOpened && noteEditText.hasFocus()) {
                    Log.d("KB", "2) openKeyboard");
                    //Do two things, make the view top visible and the editText smaller
                    noteEditText.setLines(15);
                    noteEditText.requestLayout();
                    isOpened = true;
                }
            }
        }
    });

    noteEditText.setOnClickListener(new OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("KB", "EditText onClick");
            isOpened = false;
        }
    });

    noteEditText.setOnKeyListener(new View.OnKeyListener() {
        @Override
        public boolean onKey(View v, int keyCode, KeyEvent event) {
            if (event.getKeyCode() == KeyEvent.KEYCODE_BACK) {
                Log.d("KB", "closeKeyboard");
                noteEditText.setLines(50);
                noteEditText.requestLayout();
            }
            return false;
        }
    });
}