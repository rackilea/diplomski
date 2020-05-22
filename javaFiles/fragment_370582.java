public abstract class SimpleTextWatcher implements TextWatcher {

    @Override
    public void onTextChanged(CharSequence s, int start, int before, int count) {}

    @Override
    public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

    @Override
    public void afterTextChanged(Editable s) {
        onTextChanged(s.toString());
    }

    public abstract void onTextChanged(String newValue);
}