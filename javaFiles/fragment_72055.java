facebook.setOnClickListener(new View.onClickListener(){


public void onClick(View v) {
    try{
    ApplicationInfo info = getPackageManager().getApplicationInfo("com.facebook.katana", 0 );
    boolean isFacebookInstalled = true;
        }
   catch( PackageManager.NameNotFoundException e ){
                    isFacebookInstalled=false;
              }

  if(isFacebookInstalled)
   {
       //start the facebook app
        Intent intent = new Intent("android.intent.category.LAUNCHER");
        intent.setClassName("com.facebook.katana", "com.facebook.katana.LoginActivity");
        startActivity(intent);
   }
 else
   {
    Intent facebook = new Intent(getApplicationContext(),WebActivity.class);
    startActivity(facebook);
   }
});