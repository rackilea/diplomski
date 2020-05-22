databaseReference = FirebaseDatabase.getInstance().getReference("Preschools");
                        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                    for(DataSnapshot preschool : dataSnapshot.getChildren())
                                    {
                                        if(emailAddress.getText().toString().equals(preschool.child("Admin").child("Email").getValue()) &&
                                                password.getText().toString().equals(preschool.child("Admin").child("Password").getValue()))
                                               {flag=true; break;}
                                    }