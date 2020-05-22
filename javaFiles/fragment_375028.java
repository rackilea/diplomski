public void beforeTextChanged(CharSequence s, int start, int count,int after) {
}

public void onTextChanged(CharSequence s, int start, int before, int end) {
}

public void afterTextChanged(Editable s){       
    s.clear();
}