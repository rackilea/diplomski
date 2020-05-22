firstEditText.addTextChangedListener(new TextWatcher(){
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int aft ) {

    }

    @Override
    public void afterTextChanged(Editable s){
        secondEditText.requestFocus();

    }
});