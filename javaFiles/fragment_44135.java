@Override
protected void onSaveInstanceState(Bundle outState) {
    super.onSaveInstanceState(outState);
    //don't save EditText value in a variable, instead directly get it from the EditText.
    outState.putString("text", mEditText.getText().toString()); 
}