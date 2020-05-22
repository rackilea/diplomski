this.setOnEditorActionListener(new TextView.OnEditorActionListener() {
    @Override
    public boolean onEditorAction(TextView v, int actionId, KeyEvent event) {
        if(actionId == EditorInfo.IME_ACTION_DONE) {
            myEditText.setFocusable(false);
            myEditText.setFocusableInTouchMode(false);

        }
        return false;
    }
});
this.setOnFocusChangeListener(new TextView.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(!hasFocus){
            myEditText.setFocusable(false);
            myEditText.setFocusableInTouchMode(false);
            hideKeyboardFrom(context, v);
        }
    }
});
this.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        myEditText.setFocusableInTouchMode(true);
        myEditText.setFocusable(true);
        return false;
    }
});