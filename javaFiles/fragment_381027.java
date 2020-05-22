btn1.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if ((userName.getText().toString().equals("Android")) && (pw.getText().toString().equals("123123"))) {

                result.setText("Success!");
            }
            else {
                result.setText("Failed!");
            }
        }
    });