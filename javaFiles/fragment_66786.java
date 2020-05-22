@Override
    public void onSuccess(LoginResult loginResult) {

        loginButton.setVisibility(View.INVISIBLE);
        handleFacebookAccessToken(loginResult.getAccessToken());
    }

    @Override
    public void onCancel() {

    }

    @Override
    public void onError(FacebookException error) {
        Toast.makeText(LoginActivity.this, "Login Failed.", Toast.LENGTH_LONG).show();
    }

});