Field1.addTextChangedListener(new TextWatcher() {

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start,
        int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start,
        int before, int count) {

        if (Field1.getText().toString().equals("")) {

        }
        else {
            double number1 = Double.valueOf(Field1.getText().toString());
            double number2 = Math.round((number1 * 10) / 25);
            if (keepChangingText) {
                keepChangingText = false;
                Field2.setText(String.valueOf(number2));
            } else {
                keepChangingText = true;
            }
        }
    }
});

Field2.addTextChangedListener(new TextWatcher() {

    @Override
    public void afterTextChanged(Editable s) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start,
        int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start,
        int before, int count) {

        if (Field2.getText().toString().equals("")) {

        }
        else {
            double number2 = Double.valueOf(Field2.getText().toString());
            double number1 = Math.round((number2 * 20) / 35);
            if (keepChangingText) {
                keepChangingText = false;
                Field1.setText(String.valueOf(number1));
            } else {
                keepChangingText = true;
            }

        }
    }
});