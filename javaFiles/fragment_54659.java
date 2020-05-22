@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    Log.i(TAG, "Entered onActivityResult()");
    if (resultCode == RESULT_OK){
          mUserTextView.setText(data.getStringExtra("wayback"));
}