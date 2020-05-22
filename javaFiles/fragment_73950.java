@Override
public void afterTextChanged(Editable editable) {
    if(!isCancel) {
        if(!editText.getText().toString().startsWith("₹**₹**")){
            editText.setText("₹**₹**");
            Selection.setSelection(editText.getText(), editText.getText().length());
        }
    } else {
        isCancel = false;
    }
}