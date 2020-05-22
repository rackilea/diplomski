editText.addTextChangedListener(new TextWatcher() {

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
            int after) {
    }

    @Override
    public void afterTextChanged(Editable s) {
        // we assign "theText" a value here
        theText = s.toString();
        // we test it here (assuming your main Activity is called "MainActivity"
        Toast.makeText(MainActivity.this, theText, Toast.LENGTH_LONG).show();
        // you can do whatever with the value here directly (like call "do_search"), 
        // or launch a background Thread to do it from here
    }
});