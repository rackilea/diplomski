private class CustomEditTextListener implements TextWatcher {
    private int position;

    public void setPosition(int position) {
        this.position = position;
    }

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {

    }

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {
        mDataset[position] = s.toString();
    }

    @Override
    public void afterTextChanged(Editable editable) {

    }
}