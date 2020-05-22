Button next = (Button) findViewById(R.id.goto1);
    next.setOnClickListener(new View.OnClickListener() {
        public void onClick(View view) {
            Intent intent = new Intent();
            setResult(RESULT_OK, intent);


    Button next = (Button) findViewById(R.id.goto3);
    next.setOnClickListener(new View.OnClickListener() {
       public void onClick(View view) {
           Intent myIntent = new Intent(view.getContext(), Screen3.class);
            startActivityForResult(myIntent, 0);
            finish();
        }

      });
    }
  });