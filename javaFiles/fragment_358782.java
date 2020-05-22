private class SignInOnClickListener implements View.OnClickListener {

@Override
public void onClick(View v) {
    // Get the username and password from the view
    final String username_email = mUsernameEmailEtxt.getText().toString().toLowerCase();
    final String password = mPasswordEtxt.getText().toString();
    if (isFormInputValid(username_email, password)) {
        if (emailValidator(mUsernameEmailEtxt.getText().toString())) {
            final String email = mUsernameEmailEtxt.getText().toString();
            ParseUser.logInInBackground(email, password, new LogInCallback() {
                        public void done(ParseUser user, ParseException e) {
                            if (user != null) {
                                // Hooray! The user is logged in.
                                Intent intent = new Intent(getBaseContext(), MainActivity.class)
                                        .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                                Intent.FLAG_ACTIVITY_CLEAR_TASK);
                                startActivity(intent);
                                finish();
                            } 
                        }
                    }
            );
        } else {
            ParseUser.logInInBackground(username_email, password, new LogInCallback() {
                public void done(ParseUser user, ParseException e) {
                    if (user != null) {
                        // Hooray! The user is logged in.
                        Intent intent = new Intent(getBaseContext(), MainActivity.class)
                                .addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                                        Intent.FLAG_ACTIVITY_CLEAR_TASK);
                        startActivity(intent);
                        finish();
                    } else {
                        findViewById(R.id.error).setVisibility(View.VISIBLE);
                    }
                }
            });
        }
    }
}