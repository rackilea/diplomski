DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference challengeRef = rootRef.child("Challenge");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            int senderPointsDayOne = ds.child(senderId).child("points").child("Day1").getValue(Integer.class);
            int senderPointsDayTwo = ds.child(senderId).child("points").child("Day2").getValue(Integer.class);
            int senderPointsDayThree = ds.child(senderId).child("points").child("Day3").getValue(Integer.class);

            int receiverPointsDayOne = ds.child(receiverId).child("points").child("Day1").getValue(Integer.class);
            int receiverPointsDayTwo = ds.child(receiverId).child("points").child("Day2").getValue(Integer.class);
            int receiverPointsDayThree = ds.child(receiverId).child("points").child("Day3").getValue(Integer.class);

            int senderTotal = senderPointsDayOne + senderPointsDayTwo + senderPointsDayThree;
            int receiverTotal = receiverPointsDayOne + receiverPointsDayTwo + receiverPointsDayThree;

            if(senderTotal > receiverTotal) {
                //sender is the winner
            } else if (senderTotal < receiverTotal) {
                //receiver is the winner
            } else {
                //it's even
            }
        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
challengeRef.addListenerForSingleValueEvent(valueEventListener);