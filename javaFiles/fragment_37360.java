final Button butt = (Button) findViewById(R.id.butt);

butt.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View view) {
       final EditText frag = (EditText) findViewById(R.id.frag); 
       final TextView hello = (TextView) findViewById(R.id.hello); 
       String verb = frag.getText().toString();
       if ("abc".equals(verb)) {
           hello.setText("Hello");
       }
    }
}