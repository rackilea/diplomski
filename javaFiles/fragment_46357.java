mailbutton=(ImageView)findViewById(R.id.email);
mailbutton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(),
            "This line would appear on clicking this icon",
            Toast.LENGTH_LONG).show();
                }
            });