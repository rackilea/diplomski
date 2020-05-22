DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("users");
                    databaseReference.orderByChild("username").equalTo(userNameEntered).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                                Toast.makeText(Main3Activity.this, "Username exists", Toast.LENGTH_SHORT).show();

                                //check your password in the same way and grant access if it exists too
                            else
                                // wrong details entered/ user does not exist

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });