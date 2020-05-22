private void initializeButtons() {
    Button signUpButtonClick = (Button) findViewById(R.id.signUpButton);
    signUpButtonClick.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            startActivity(new Intent(MainActivity.this, Signup.class));
        }
    });

    Button anotherButton = (Button) findViewById(R.id.anotherButton);
    anotherButton.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            Log.d("TAG", "Clicked on another button!");
        }
    });
}