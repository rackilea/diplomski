@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {

    // Pass on the activity result to the helper for handling
    if (mHelper==null || !mHelper.handleActivityResult(requestCode, resultCode, data)) {
        // not handled, so handle it ourselves (here's where you'd
        // perform any handling of activity results not related to in-app
        // billing...
    }
    else {
        Log.d(TAG, "onActivityResult handled by IABUtil.");
    }
    super.onActivityResult(requestCode, resultCode, data);
}