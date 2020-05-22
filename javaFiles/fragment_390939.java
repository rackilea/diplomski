FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
if(user!=null){
    us.addValueEventlistner(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            if(dataSnapshot.exists()){
                Intent intent = new Intent(VerifyPhoneActivity.this, DriverHome.class);
                startActivity(intent);
                finish(); }
            else{
                Intent gotoUserInfo=new Intent(VerifyPhoneActivity.this,UserInformationActivity.class);
                startActivity(gotoUserInfo);
                finish();
            } }
        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {
        }
    });
}
else {
    Intent intent = new Intent(VerifyPhoneActivity.this, StartActivity.class);
    startActivity(intent);
    finish();
}