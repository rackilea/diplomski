private static final String MY_EDIT_TEXT_VISIBILITY = "my_edit_text_visibility";
private static final String MY_TEXT_VIEW_VISIBILITY - "my_text_view_visibility";
private static final String MY_BUTTON_VISIBILITY - "my_button_visibility";

@Override
protected void onSaveInstanceState (Bundle outState) {
    super.onSaveInstanceState(outState);

    //Save the state of each of these. It's super important to add null checks here
    //(which is why I prefer to let the View handle it) as in some cases this can
    //get called after the Views have been destroyed.

    if (myEditText != null) {
        outState.putInt(MY_EDIT_TEXT_VISIBILITY, myEditText.getVisibility());
    }

    if (myTextView != null) {
        outState.putInt(MY_TEXT_VIEW_VISIBILITY, myTextView.getVisibility());
    }

    if (myButton != null) {
        outState.putInt(MY_BUTTON_VISIBILITY, myButton.getVisibility());
    }
}

@Override
protected void onRestoreInstanceState (Bundle savedInstanceState) {
    super.onRestoreInstanceState(savedInstanceState);

    //Check if we have saved state, and restore the visibility 
    //to all of the Views we care about
    if (savedInstanceState != null) {
        myEditText.setVisibility(savedInstanceState.getInt(MY_EDIT_TEXT_VISIBILITY, myEditText.getVisibility()));
        myTextView.setVisibility(savedInstanceState.getInt(MY_TEXT_VIEW_VISIBILITY, myTextView.getVisibility()));
        myButton.setVisibility(savedInstanceState.getInt(MY_BUTTON_VISIBILITY, myButton.getVisibility()));
    }
}