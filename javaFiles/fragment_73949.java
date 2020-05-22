btnCancel.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        isCancel = true;
        editText.setText("");
    }
});