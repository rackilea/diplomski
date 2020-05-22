String email = mEmail.getText().toString();
String password = mPassword.getText().toString();

if(email.isEmpty() || password.isEmpty())
    return;    //you need to display message to the user

mAuth.createUserWithEmailAndPassword(email, password)
.addOnCompleteListener(CustomerLoginActivity.this, new OnCompleteListener<AuthResult>() 
{ 
    ...
})