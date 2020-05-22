editText.addTextChangedListener(new TextWatcher() {

    public void beforeTextChanged(CharSequence charSequence, int start, int count, int after) {

        Log.e(TAG, "111 text =---------------" + charSequence);
    }

    public void onTextChanged(CharSequence charSequence, int start, int before, int count){

        Log.e(TAG, "222 text =---------------" + charSequence);
    }

    public void afterTextChanged(Editable editable) {

        Log.e(TAG, "333 text ---------------" + editable);
    }
});