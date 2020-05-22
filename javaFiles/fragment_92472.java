public void signIn(View view) {

    String test =  ((EditText) view.findViewById(R.id.usernameField)).getText().toString();

    Toast.makeText(MainActivity.this, test, Toast.LENGTH_SHORT).show();

}