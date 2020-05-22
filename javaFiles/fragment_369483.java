button.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
        int length = editText.getSelectionStart();
        if (length > 0) {
            editText.getText().delete(length - 1, length);
            edittext.setSelection(length-1);
        }
    }
});