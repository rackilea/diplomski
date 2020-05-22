public void doThis(MenuItem item){
       // Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), DealsList.class);
        finish();
        startActivity(intent);
    }

    public void gotoLocation(MenuItem item){
        // Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), AddLocation.class);
        finish();
        startActivity(intent);
    }

    public void userProfile(MenuItem item){
        // Toast.makeText(this, "Hello World", Toast.LENGTH_LONG).show();
        Intent intent = new Intent(getApplicationContext(), UserProfile.class);
        finish();
        startActivity(intent);
    }