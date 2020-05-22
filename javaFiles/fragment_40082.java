DatabaseReference billRef = FirebaseDatabase.getInstance().getReference();
    billRef.child("Bill").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot allValueSnap) {
            for (DataSnapshot snapshot: allValueSnap.getChildren()){
                String key = snapshot.getKey();
                if (key != null) {
                    billRef.child("Bill").child(key).child("Breakfast").addListenerForSingleValueEvent(new ValueEventListener() {
                        @Override
                        public void onDataChange(@NonNull DataSnapshot keySnapshot) {
                            for (DataSnapshot dateSnapshot:keySnapshot.getChildren()){
                                String keyDate = dateSnapshot.getKey();
                                long totalValue =(long) keySnapshot.child(keyDate).child("Total").getValue();
                                Log.i("totalBreakFast","STotal: "+String.valueOf(totalValue));
                                breakfastBills.add(totalValue);
                            }
                            if(!keySnapshot.exists()){
                                Log.i("totalBreakFast","NoData: ");
                            }
                        }
                        @Override
                        public void onCancelled(@NonNull DatabaseError databaseError) {

                        }
                    });
                }

            }
        }
        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });