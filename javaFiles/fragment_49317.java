> firebase will  check it Self User is Authenticated or not so you  can not
  to check Manually.




 private void loginUserWithFirebase(String email, String password) {
           firebaseAuthLogin.signInWithEmailAndPassword(email, password)
                   .addOnCompleteListener(getActivity(), new OnCompleteListener<AuthResult>() {
                       @Override
                       public void onComplete(@NonNull Task<AuthResult> task) {

                           if (task.isSuccessful()) {

                               startActivity(new Intent(LoginActivity.this, MainActivity.class));



 }
                           else{

                               Toast.makeText(getContext(), "" + task.getException().toString(), Toast.LENGTH_SHORT).show();
                           }
                       }
                   });
       }