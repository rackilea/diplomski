mAuth.signInWithCredential(credential).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
    @Override
    public void onComplete(@NonNull Task<AuthResult> task) {
        boolean isNewUser = task.getResult().getAdditionalUserInfo().isNewUser();
        if (isNewUser) {
            Log.d(TAG, "Is New User!"); //Restrict the authentication process
        } else {
            Log.d(TAG, "Is Old User!"); //Allow user to authenticate
        }
    }
});