editText.addTextChangedListener(new TextWatcher() {

    String initialText = "";
    private boolean ignore = true;

    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        if ( initialText.length() < charSequence.length() ){

            initialText = charSequence.toString();
            Log.e(TAG, "111 text ---------------" + charSequence);
        }
    }

    public void onTextChanged(CharSequence charSequence, int start, int before, int count){

        if( initialText.length() < charSequence.length() ) {

            initialText="";
            ignore=false;
            Log.e(TAG, "222 text ---------------" + charSequence);
        }
    }

    public void afterTextChanged(Editable editable) {

        if(!ignore) {

            ignore = true;
            Log.e(TAG, "333 text ---------------" + editable);
        }
    }
});