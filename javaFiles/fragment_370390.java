FirebaseUser user = firebaseAuth.getCurrentUser();
                if (user != null) {
                    // User is signed in, send to mainmenu
                    Log.d(TAG, "onAuthStateChanged:signed_in:" + user.getUid());
                    startActivity(new Intent(SplashScreenActivity.this, MainMenuActivity.class));
                } else {
                    // User is signed out, send to register/login
                    startActivity(new Intent(SplashScreenActivity.this, MainActivity.class));
                }