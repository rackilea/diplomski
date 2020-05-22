String emailAddress = etSignInEmail.getText().toString().trim();
    if (etSignInPassword.getText().toString().length() < 6) {
    etSignInPassword.setError(getString("password minimum contain 6 character));
    etSignInPassword.requestFocus();
    }
    if (etSignInPassword.getText().toString().equals("")) {
    etSignInPassword.setError(getString("please enter password));
    etSignInPassword.requestFocus();
    }
    if (!android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
    etSignInEmail.setError(getString("please enter valid email address));
    etSignInEmail.requestFocus();
    }
    if (etSignInEmail.getText().toString().equals("")) {
    etSignInEmail.setError(getString("please enter email address));
    etSignInEmail.requestFocus();
    }
    if (!emailAddress.equals("") &&
    etSignInPassword.getText().toString().length() >= 6 &&
    !etSignInPassword.getText().toString().trim().equals("")
    && android.util.Patterns.EMAIL_ADDRESS.matcher(emailAddress).matches()) {
    // do  your action
    }