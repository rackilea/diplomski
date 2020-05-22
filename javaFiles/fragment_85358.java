toolbar.setNavigationOnClickListener(new View.OnClickListener() {

    @Override
    public void onClick(View v) {
        // back button is pressed
        mListener.onHomePressed();
    }
});