entry01.setOnFocusChangeListener(
new OnFocusChangeListener() {
    public void onFocusChange(View v, boolean hasFocus) {
        prenom = entry01.getText().toString();
        if(entry01.getText().toString().equals(""));
                entry01.setHint("20 lettres max"); // means "20 character max"
        }
    });