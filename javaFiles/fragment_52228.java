Button a = (Button) findViewById(R.id.button_a);
EdiText et = (EditText) findViewById(R.id.edit_text);

OnClickListener aClickListener = new OnClickListener() {
  public void onClick(View v) {
    String current = et.getText().toString();
    et.setText(current + "a");
  }
};    

a.setOnClickListener(aClickListener);