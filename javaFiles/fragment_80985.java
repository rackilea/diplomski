final EditText editText = (EditText) findViewById(R.id.text);
editText.addTextChangedListener(new TextWatcher() {

boolean ignore = false;

@Override
public void beforeTextChanged(CharSequence s, int start, int count, int after) {
}

@Override
public void onTextChanged(CharSequence s, int start, int before, int count) {
}

private boolean shouldIgnore(char input) {
    return !(input >= '0' && input <= '9');
}

@Override
public void afterTextChanged(Editable s) {
    int idx_of_last = s.length() - 1;
    if (!ignore && idx_of_last >= 0) {
        char last = s.charAt(idx_of_last);
        if (shouldIgnore(last)) {
            if (s.length() == 1 || (s.length() > 1 && shouldIgnore(s.charAt(idx_of_last - 1)))) {
                ignore = true;
                s.delete(idx_of_last, idx_of_last + 1); // after this , onTextChanged will be called
                ignore = false;
            } else {
                Log.d("KEY_CHANGE", "Format Right");
            }
        } else {
            Log.d("KEY_CHANGE", "Last Is Number");
        }
    }
}

});