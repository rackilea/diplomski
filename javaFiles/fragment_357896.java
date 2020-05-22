GoogleSignInOptions options = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
        .requestIdToken(application.getString(R.string.default_web_client_id))
        .requestEmail()
        .build();

GoogleSignInClient googleClient = GoogleSignIn.getClient(application, options);
googleClient.signOut();