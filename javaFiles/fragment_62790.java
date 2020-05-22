myRef.child("(username)").child("rating").child(category).addListenerForSingleValueEvent(new ValueEventListener() {
                    @Override
                    public void onDataChange(DataSnapshot dataSnapshot) {
                        for (DataSnapshot ds : dataSnapshot.getChildren()) {
                            String str = (String) dataSnapshot.child("avg").getValue(String.class);
                            if (str != null) {
                                avgrate = Double.parseDouble(str);
                                ratetxt.setVisibility(View.VISIBLE);
                                ratetxt.setText("AVG. RATE: "+avgrate+"");
                            }
                        }
                    }
                    @Override
                    public void onCancelled(DatabaseError databaseError) {
                        Toast.makeText(getApplicationContext(), "ERROR", Toast.LENGTH_SHORT).show();
                    }
                });