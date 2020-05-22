final EditText editText = (EditText) findViewById(R.id.editText);
editText.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {
    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        //Check if the entered character is the first character of the input
        if(start == 0 && before == 0){
            //Get the input
            String input = s.toString();
            //Capitalize the input (you can also use StringUtils here)
            String output = input.substring(0,1).toUpperCase() + input.substring(1);
            //Set the capitalized input as the editText text
            editText.setText(output);
            //Set the cursor at the end of the first character
            editText.setSelection(1);
        }
    }

    @Override
    public void afterTextChanged(Editable s) {
    }
});