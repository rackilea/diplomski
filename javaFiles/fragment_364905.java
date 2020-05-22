FirebaseUser user=FirebaseAuth.getInstance().getCurrentUser();
if(user!=null){
     //Signed in, go to home activity
    Intent i=new Intent(SplashActivity.this,HomeActivity.class);
    startActivity(i);
  } 
  else{
      //not logged in
      Intent intent=new Intent(SplashActivity.this,LoginActivity.class);
      startActivity(intent);
     }