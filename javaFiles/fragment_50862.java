builder.setNegativeButton("No", null);
final AlertDialog dialog = builder.create();
dialog.show();
editText.addTextChangedListener(new TextWatcher() {

    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    public void onTextChanged(CharSequence s, int start, int before, int count) 
    {

        String text = editText.getText().toString();
        ...
        ...
        button = dialog.getButton(AlertDialog.BUTTON_POSITIVE);
        if(button != null) {    
            if(text.trim().length()>0) {
                button.setEnabled(true);
            }
            else {
                button.setEnabled(false);
            }
        }
    }
    ...
...