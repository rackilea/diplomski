String userPasswordNew = newPassword.getText().toString();
String userPassword2New = newPassword2.getText().toString();

if(!userPasswordNew.equals("") && !userPassword2New.equals("")){
    if(userPasswordNew.equals(userPassword2New)){
        FirebaseUser user = FirebaseAuth.getInstance().getCurrentUser();
        AuthCredential credential = EmailAuthProvider
                .getCredential("user@example.com", "password1234");
        user.reauthenticate(credential)
                .addOnCompleteListener(new OnCompleteListener<Void>() {
                    @Override
                    public void onComplete(@NonNull Task<Void> task) {
                        if (task.isSuccessful()) {
                            user.updatePassword(userPasswordNew).addOnCompleteListener(new OnCompleteListener<Void>() {
                                @Override
                                public void onComplete(@NonNull Task<Void> task) {
                                    if (task.isSuccessful()) {
                                        Log.d(TAG, "Password updated");
                                    } else {
                                        Log.d(TAG, "Error password not updated")
                                    }
                                }
                            });
                        } else {
                            Log.d(TAG, "Error auth failed")
                        }
                    }
                });
    }else{
        Log.d("Password", "Does Not Match");
    }
}else{
    Log.d("Password", "Fill the Edittext");
}