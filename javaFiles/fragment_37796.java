@Override
protected void onCreate(Bundle savedInstanceState) {
    //Some extra stuffs removed for better readability 
    . . .
    navigationView = findViewById(R.id.nav_view);
    navigationView.setNavigationItemSelectedListener(this); // You missed this line, add this to your code
    . . .
    //Some extra stuffs removed for better readability also
}