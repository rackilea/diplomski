if((preferences.getBoolean("configured", false)) == false) { // app has not yet been set-up
        Intent intent = new Intent(this, midamcorp.com.burgerkingapp.preferences.class);
        intent.putExtra("setUp", true);
        startActivity(intent);
    } 
    else {
        Calendar cal = Calendar.getInstance();
        if(cal.get(Calendar.HOUR_OF_DAY) > 4 && (cal.get(Calendar.HOUR_OF_DAY) <= 10  && cal.get(Calendar.MINUTE) < 28))
        {

            Intent intent = new Intent(this, breakfastHome.class);
            startActivity(intent);
        } else {
            Intent intent = new Intent(this, lunchHome.class);
            startActivity(intent);
        }
    }