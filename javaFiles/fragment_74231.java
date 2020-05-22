mAuth=FirebaseAuth.getInstance();
user=mAuth.getCurrentUser();
user.reload()
if(!user.isEmailVerified()){
     startActivity(new Intent(HomePage.this,VerifyEmail.class));
}