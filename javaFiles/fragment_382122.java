public void clickMe (View view){
    EditText mEditText = (EditText) findViewById(R.id.mEditText);
    if (mEditText.getVisibility() == View.VISIBLE) {
        //TO DO
    } else {
        mEditText.setVisibility(View.VISIBLE);
    }
}