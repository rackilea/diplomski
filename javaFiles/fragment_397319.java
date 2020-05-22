input.addTextChangedListener(new TextWatcher() {
    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (input.getText().toString().length() >= 4 && !justEdited) {
            justEdited = true;
            input.setText(addComma(input.getText().toString()));
        } else if (justEdited) {
            justEdited = false;
        }
    }
}