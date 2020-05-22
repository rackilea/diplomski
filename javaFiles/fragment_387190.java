public void CheckPassword(View view) {
    password = PasswordManagement.getPassword(this);
    TextView txtPassword = findViewById(R.id.txtPassword);

    if (txtPassword.getText().toString().equals(password)) {
        Intent intent;
        intent = new Intent(this, WelcomeActivity.class);
        intent.putExtra("password", password);
        startActivityForResult(intent, 1);
        // startActivity(intent);
    } else {
        Intent intent;
        intent = new Intent(this, RestrictedActivity.class);
        startActivityForResult(intent, 1);
        //startActivity(intent);
    }
}