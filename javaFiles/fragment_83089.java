yourEditText.setOnFocusChangeListener(new OnFocusChangeListener() {
    @Override
    public void onFocusChange(View view, boolean hasFocus) {
        if (!hasFocus) {
            EditText edt = (EditText) view;  
            if(!TextUtils.isEmpty(edt.getText()) && edt.getText().toString().trim().length < 2) {
              edt.setText("0" + edt.getText().toString().trim());
            }
        } 
    }
});