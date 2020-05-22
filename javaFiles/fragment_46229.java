final DatabaseReference databaseReference = FirebaseDatabase.getInstance().getReference().child("qrcode");
                    databaseReference.orderByChild("Result").equalTo(code).addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                            if(dataSnapshot.exists())
                                Toast.makeText(Main3Activity.this, "Code exists", Toast.LENGTH_SHORT).show();
                            else
                                writeNewCode(code);

                        }

                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });