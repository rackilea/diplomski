dropDownTab.setOnTouchListener(new OnTouchListener() {
    public void onTouch(View v, MotionEvent e) {
        // Make the drop down menu finger follow the finger position.
        // Use again dropDownView.setTranslationY(...) to move the view.
        // If the drop down menu has been dragged a certain distance, make it move out by itself using the animation as above.
    }
});