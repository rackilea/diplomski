final EditText text_box2;
    text_box2 = (EditText) findViewById(R.id.fillingPressure);
    text_box2.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            if (text_box2.getText().toString().compareTo("0.0") == 0) {
                text_box2.setText("");
            }
        }
    }
});

final EditText text_box1;
text_box1 = (EditText) findViewById(R.id.tankVolume);
text_box1.setOnFocusChangeListener(new View.OnFocusChangeListener() {
    @Override
    public void onFocusChange(View v, boolean hasFocus) {
        if (hasFocus) {
            if (text_box1.getText().toString().compareTo("0.0") == 0) {
                text_box1.setText("");
            }
        }
    }
});