public void logIn() {
    facebookSpinner.setVisibility(View.VISIBLE);
    mLoginButton.setVisibility(View.GONE);
    facebook.authorize(FacebookLogInActivity.this, PERMISSIONS, Facebook.FORCE_DIALOG_AUTH, new DialogListener() {
        @Override
        public void onComplete(Bundle values) {
            SharedPreferences.Editor editor = mPrefs.edit();
            editor.putString("access_token", facebook.getAccessToken());
            editor.putLong("access_expires", facebook.getAccessExpires());
            editor.commit();
            requestUserData();
        }

        @Override
        public void onFacebookError(FacebookError e) {
            mLoginButton.setVisibility(View.VISIBLE);
            hideSpinners();
        }

        @Override
        public void onError(DialogError e) {
            mLoginButton.setVisibility(View.VISIBLE);
            hideSpinners();
        }

        @Override
        public void onCancel() {
            mLoginButton.setVisibility(View.VISIBLE);
            hideSpinners();
        }
    });
}