RelativeLayout currentView = (RelativeLayout) findViewById( R.id.MyRelativeLayout );
currentView.addView(aSubView);
currentView.addView(aSubButton);
currentView.addView(aSubTextView);

currentView.setOnTouchListener(new OnTouchListener() {
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        // Here you will receive all the motion event.
        return false;
    }
});