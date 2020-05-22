if (isUserLoggedOut(StartActivity.this)) {
                    startActivity(new Intent(StartActivity.this, LoginActivity.class));
                    finish();
                } else {
                    startActivity(new Intent(StartActivity.this, MainActivity.class));
                    finish();
                }