EditText input = (EditText) findViewById(R.id.ip);
    Button button = (Button) findViewById(R.id.calcbutton);
    TextView textView = findViewById(R.id.tv15);


    button.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {

           int num = Integer.parseInt(input.getText().toString());
          // for 0.15%
          float fifteen_percent = (float) ((num * 0.15) + num);
          textView.setText(String.valueOf(fifteen_percent));
        }
    });