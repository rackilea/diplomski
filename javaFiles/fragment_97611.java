private String value;

mEditPrice.addTextChangedListener(new TextWatcher(){
    DecimalFormat dec = new DecimalFormat("0.00");

    @Override
    public void afterTextChanged(Editable arg0) {
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        if (!s.toString().equals(value)){
            String userInput = mEditPrice.getText().toString().replaceAll("[^\\d]", "");
            double userInputDouble = Double.parseDouble(userInput);
            value = ("$"+dec.format(userInputDouble / 100));

            mEditPrice.setText(value);
            mEditPrice.setSelection(value.length());
        }
    }
});