if (isFirstTime) 
{   
   //implement your first time logic
   editor.putBoolean("isFirstTime", false);
   editor.commit();
   Intent mainIntent;
   mainIntent = new Intent(SplashActivity.this, LoginActivity.class);
   startActivity(mainIntent);
   finish();  
}