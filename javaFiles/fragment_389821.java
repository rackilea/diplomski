myEditText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus)
            myEditText.setHint("new hint");
        else
            myEditText.setHint("");
    }
});