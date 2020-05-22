auth.createUserWithEmailAndPassword(edtEmail.getText().toString(),edtPassword.getText().toString())
        .addOnSuccessListener(new OnSuccessListener<AuthResult>() {

            @Override
            public void onSuccess(AuthResult authResult) {
                //Save user to db
                ....
            }
        })
        .addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {
                ....
            }
        });