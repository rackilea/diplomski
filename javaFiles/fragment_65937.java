new Handler().postDelayed(new Runnable() {

                @Override
                public void run() {
                    startActivity(new Intent(SplashActivity.this,
                            YourMainMenuActivity.class));
                    finish();
                }
            }, 3000);