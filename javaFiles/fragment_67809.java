Button signUpButtonClick = (Button) findViewById(R.id.signUpButton);
signUpButtonClick.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {
        startActivity(new Intent(MainActivity.this, Signup.class));
    }
});