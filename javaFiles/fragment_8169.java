signin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               final ProgressDialog mdialog = new       ProgressDialog(SigninMainActivity.this);
                mdialog.setMessage("Please waiting");
                mdialog.show();
                table_user.addValueEventListener(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        //check if user not exist
                        if (dataSnapshot.child(phone.getText().toString()).exists()) {
                            //Get User Information
                            mdialog.dismiss();

                            User user = dataSnapshot.child(phone.getText().toString()).getValue(User.class);
//Check the null
                           if (user.getPassword() != null && password.getText() != null && user.getPassword().equals(password.getText().toString())) {
                                Intent homeIntent= new Intent(SigninMainActivity.this, home.class);
                                Common.currentUser = user;
                                startActivity(homeIntent);
                                finish();
                            } else {

                                Toast.makeText(SigninMainActivity.this, "Sign in failed", Toast.LENGTH_SHORT).show();


                            }
                        }else{
                            mdialog.dismiss();
                            Toast.makeText(SigninMainActivity.this, "User Does Not exist", Toast.LENGTH_SHORT).show();
                        }
                    }