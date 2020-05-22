protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_splash);

    Intent i = new Intent(Splash.this, DashBoard.class);

    if(isInternetAvailable(Splash.this)){
        startActivity(i);
        finish();
    }
    else{
        Toast toast = Toast.makeText(Splash.this, 
            "Please check your internet options...", Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
        finish();
    }
}