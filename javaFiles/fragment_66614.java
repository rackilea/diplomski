btnLogin.setOnClickListener(new View.OnClickListener() {

    public void onClick(View view) {
        String email = inputEmail.getText().toString();
        String password = inputPassword.getText().toString();

        // Check for empty data in the form
        if (email.trim().length() > 0 && password.trim().length() > 0) {
            // login user
            checkLogin(email, password);
        } else {
            // Prompt user to enter credentials
            Toast.makeText(getApplicationContext(),
                    "Please enter the credentials!", Toast.LENGTH_LONG)
                    .show();
        }
    }

});