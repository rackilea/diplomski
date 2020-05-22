DatabaseReference RedLineRouteReference = FirebaseDatabase.getInstance().getReference().child("RedLineRoute");
            RedLineRouteReference.addValueEventListener(new ValueEventListener() {
                @Override
                public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

                    ArrayList<String> youNameArray = new ArrayList<>();

                    for (DataSnapshot snapshot : dataSnapshot.getChildren()){
                        String data = snapshot.getKey();
                        youNameArray.add(data);
                    }

                    Log.v(TAG, "First data : " + youNameArray.get(0));
                    Log.v(TAG, "Second data : " + youNameArray.get(1));


                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {

                }
            });