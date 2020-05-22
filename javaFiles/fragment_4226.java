edittext.addTextChangedListener(new TextWatcher() {

    public void onTextChanged(CharSequence s, int start, int before,
            int count) {

               if(!edittext.getText().toString().contains("@")) {
                     edittext.setError("@ not detected");
                 }
    }


    public void beforeTextChanged(CharSequence s, int start, int count,
            int after) {

    }

    public void afterTextChanged(Editable s) {

    }
});