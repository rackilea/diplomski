TextWatcher textWatcher = new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        edt.removeTextChangedListener(textWatcher);
        String text = edt.getText().toString();
        text = text.replace("  ", ",");
        edt.setText(text);
        edt.setSelection(text.length());
        edt.addTextChangedListener(textWatcher);
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
};