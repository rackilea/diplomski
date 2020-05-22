editText1.addTextChangedListener(new TextWatcher(){
    public void onTextChanged(CharSequence s, int start, int before, int count)
    {
        if (editText1.getText().toString().matches("^0") )
        {
            // Not allowed
            Toast.makeText(context, "not allowed", Toast.LENGTH_LONG).show();
            editText1.setText("");
        }
    }
    @Override
    public void afterTextChanged(Editable arg0) { }
    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}
});