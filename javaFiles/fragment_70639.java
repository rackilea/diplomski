mAuthListener = new FirebaseAuth.AuthStateListener() {
            @Override
            public void onAuthStateChanged(@NonNull FirebaseAuth firebaseAuth) {
                FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in
                  //  Intent intent = new Intent(getBaseContext(), MainActivity.class);
                    //intent.putExtra("EXTRA_SESSION_ID", sessionId);
                  //  startActivity(intent);
                   // Log.d("LOG_Login", "onAuthStateChanged:signed_in:" + user.getUid());
                } else {
                    // User is signed out
                    String className = this.getClass().getName();
                    if (!(className == "LoginActivity")) {
                         Intent intent = new Intent(getBaseContext(), LoginActivity.class);
                       // intent.putExtra("EXTRA_SESSION_ID", sessionId);
                         startActivity(intent);
                    }

                    Log.d("LOG_Login", "onAuthStateChanged:signed_out");
                }
                // ...
            }
        };

        mAuth.addAuthStateListener(mAuthListener);