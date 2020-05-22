@Override
    public void onAuthenticationSucceeded(FingerprintManager.AuthenticationResult result) {
        this.update("Fingerprint Authentication succeeded.", true);
        //notify the caller about success
        callback.onAuthenticationSucceed();
    }