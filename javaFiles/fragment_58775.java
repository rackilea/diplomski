Button B = (Button) findViewById(R.id.B);
B.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            EditText A = (EditText) findViewById(R.id.A);
            TextView C = (TextView) findViewById(R.id.C);
            String AA=A.getText().toString();
            if(A.length()>0){
                C.setText(AA);
            }else{
                Toast.makeText(getApplicationContext(), "TRY AGAIN",
                Toast.LENGTH_LONG).show();
            }
        }
    });