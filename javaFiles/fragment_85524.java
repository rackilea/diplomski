edt.addTextChangedListener(new TextWatcher() {
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {}

    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {}
@Override
public void afterTextChanged(Editable editable) {

if(edt.getText().toString()==""&&edt.getText().toString().equals(null)){
}
else {
    edt.setOnFocusChangeListener(new View.OnFocusChangeListener() {
        @Override
        public void onFocusChange(View v, boolean hasFocus) {
            if (!hasFocus)//Perform Click when edt loses Focus {
                btn.callOnClick();
            }
        }
    });
}
}});