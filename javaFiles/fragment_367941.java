@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
    if (requestCode == 1) {
        if (resultCode == RESULT_OK) {
            // code for result
            aString = getIntent().getExtras().getString("aString");
            backFromChild = true;
        }
        if (resultCode == RESULT_CANCELED) {
            // Write your code on no result return
        }
    }
}