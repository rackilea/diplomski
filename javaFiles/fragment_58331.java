@Override
protected void onCreate(Bundle splash) {
    super.onCreate(splash);
    setContentView(R.layout.splash);

    // start MainActivity here

     Intent intent=new Intent(this,MainActivity.class);
     startActivity(intent);
}