EditText edittext = (EditText)findViewById(R.id.myedittext);
edittext.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if(hasFocus) {
            //handle your situation here
        }
    }
});