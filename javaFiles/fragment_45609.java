SharedPreferences preferences = getSharedPreferences("myPref",   getApplicationContext().MODE_PRIVATE);
    index = preferences.getInt("choice",-1);

 if (index == 1) {
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                        getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                        getWindow().setStatusBarColor(MainActivity.this.getResources().getColor(R.color.redDark));
                        toolbar.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.red));
                        Toast.makeText(MainActivity.this, "Rosso OK", Toast.LENGTH_SHORT).show();
                        Log.i("Colors", "Rosso Ok");                  
                    }
            } else if (index ==2) {
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    getWindow().setStatusBarColor(MainActivity.this.getResources().getColor(R.color.green_welcome));
                    toolbar.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.green));                 
                }

            } else if (index == 3){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    getWindow().setStatusBarColor(MainActivity.this.getResources().getColor(R.color.primary_dark_blue));
                    toolbar.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.primary_blue));      
                }
            } else if (index == 4){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    getWindow().setStatusBarColor(MainActivity.this.getResources().getColor(R.color.yellowDark));
                    toolbar.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.yellow));      
                }
            } else if (index == 5){
                if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                    getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                    getWindow().setStatusBarColor(MainActivity.this.getResources().getColor(R.color.dark_orange));
                    toolbar.setBackgroundColor(MainActivity.this.getResources().getColor(R.color.main_orange));      
                }