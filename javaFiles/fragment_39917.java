databaseReference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
            cCESnapshot = dataSnapshot.child(uid).child("currChallenges").child(challengeList.get(position));

    Intent intent = new Intent();
    intent.setClass(this, ChallengeView.class);
    intent.putExtra("snapshot", cCESnapshot.toString());
    intent.putExtra("name", challengeList.get(position));
    startActivity(intent);
        }

        @Override
        public void onCancelled(@NonNull DatabaseError databaseError) {

        }
    });