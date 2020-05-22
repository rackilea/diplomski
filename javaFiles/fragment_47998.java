new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                    startActivity(new Intent(SplashScreen.this, 
                    yourHomeActivity.class));
                    finish();
                }
            }
        },3000);