@Override
protected void onActivityResult(int requestCode, int resultCode, Intent data) {
super.onActivityResult(requestCode, resultCode, data);
if(requestCode == RC_SIGN_IN) {
    if(resultCode == RESULT_OK) {
        //User logged in
        Log.d("AUTH", auth.getCurrentUser().getEmail());
//create the database
        DatabaseReference mdatabase=FirebaseDatabase.getInstance.getReference.child("User-Information");

        //set the information, you can put how much as you want
        mdatabase.child("user-information1").setValue("User-information1");
        mdatabase.child("user-information2").setValue("User-information2")
             .addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    Log.d(LOG_TAG, "signIn:onComplete:" + task.isSuccessful());

                    if (task.isSuccessful()) {
                        //success
                    } else {
                        //Error

                    }
                }
            });;

        Intent intent = new Intent(this, com.jacob.appdevitae.HomeActivity.class);
        startActivity(intent);
        finish();
    }
    else {
        //User not authenticated
        Log.d("AUTH", "NOT AUTHENTICATED");
    }
}