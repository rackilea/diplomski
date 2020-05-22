auth.createUserWithEmailAndPassword(email, password)
        .addOnCompleteListener(CreateActivity.this, new 
          OnCompleteListener<AuthResult>() {

            public void onComplete( Task<AuthResult> task) {
                Toast.makeText(CreateActivity.this, "創建成功，請重新登 入", Toast.LENGTH_SHORT).show();

                // If sign in fails, display a message to the user. If sign in succeeds
                // the auth state listener will be notified and logic to handle the
                // signed in user can be handled in the listener.
                if (!task.isSuccessful()) {
                    Toast.makeText(CreateActivity.this, "認證失敗或帳號已 存在" , Toast.LENGTH_SHORT).show();
                } else {
                // insert user to database
                    FirebaseDatabase database = FirebaseDatabase.getInstance();
                    String currentUid = auth.getCurrentUser().getUid();
                    DatabaseReference myRef = database.getReference("Contacts/" + currentUid);
                    ContactInfo contact1 = new ContactInfo(email,id,password);
                    myRef.setValue(contact1);//將會員資料寫入FIREBASE
                    startActivity(new Intent(CreateActivity.this, MainActivity.class));
                    finish();
                }
            }
        });


}