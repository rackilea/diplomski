public void signMeIn(View v){
    String email = (String) ((EditText)findViewById(R.id.signInEmailText)).getText().toString();
    String password = (String) ((EditText)findViewById(R.id.signInPasswordText)).getText().toString();

    UserCredentialsAsync uca = new UserCredentialsAsync(getApplicationContext());
    uca.signIn(email, password);
    uca.execute();
}