edittext.addTextChangedListener(new TextWatcher() {

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        // do some stuff

    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count,
            int after) {
        // do some stuff

    }

    @Override
    public void afterTextChanged(Editable s) {
        // do some stuff

    }
});