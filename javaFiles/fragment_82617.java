public void startSignUp(){

    String name = mName.getText().toString();
    String email = mEmailField.getText().toString();
    String newPass = mNewPass.getText().toString();
    String conPass = mConfirmPass.getText().toString();

    if(TextUtils.isEmpty(name) || TextUtils.isEmpty(email) || TextUtils.isEmpty(newPass) || TextUtils.isEmpty(conPass)){
        Toast.makeText(SignUp.this, "Fields Empty" , Toast.LENGTH_LONG).show();
    }
        mAuth.createUserWithEmailAndPassword(email,newPass).addOnCompleteListener(this, new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(! task.isSuccessful()){
                    Toast.makeText(SignUp.this, "SignUp Failed", Toast.LENGTH_LONG).show();
                }else {
                    openAuthetication();
                }
            }
        });
    }
}