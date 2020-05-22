mQueryEditor.setOnTouchListener(new View.OnTouchListener() {
    @Override
    public boolean onTouch(View view, MotionEvent motionEvent) {
        mQueryEditor.showDropDown();
        mQueryEditor.requestFocus();
        return false;
    }
});