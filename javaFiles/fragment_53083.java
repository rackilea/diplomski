btn_show.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        input_msg = nametext.getText().toString();
        nametext.setText("Hi, " + input_msg); 
  }
 });