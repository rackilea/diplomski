delButton = (Button) findViewById(R.id.button);

delButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Toast.makeText(getApplicationContext(), tvemail.getText() + " deleted", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(DetailsActivity.this, MainActivity.class));
            helpher.deleteARow((String) tvemail.getText());
        }
    });