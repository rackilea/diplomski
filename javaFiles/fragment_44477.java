public String Setphase2(Button r,Button l,TextView t,EditText i) {
    i.setText(""); // See this line**************
    r.setText(R.string.upload);
    l.setText(R.string.edit);
    t.setText(R.string.key_task);
    String inputText = i.getText().toString();
    Log.d("UserText", "Entry text is:" + inputText);
    i.setInputType(InputType.TYPE_TEXT_VARIATION_PASSWORD);
    return inputText;
}