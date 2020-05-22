new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent in = new Intent(getApplicationContext(), Afspl.class);
                startActivity(in);
            }
}, 1000);