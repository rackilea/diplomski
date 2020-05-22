button.setOnClickListener(new View.OnClickListener() {
  public void onClick(View v) {
    Intent i=new Intent(Caller.this, Called.class);
    startActivity(i);
  }
};