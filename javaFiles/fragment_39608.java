edittext.addTextChangedListener(new TextWatcher(){
    @Override
    public void afterTextChanged(Editable s) {
        if (editText.getText().length() == 2) {
            editText.setText(editText.getText() + ":");
            editText.setSelection(et.getText().length());
        }
    }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {} 
}