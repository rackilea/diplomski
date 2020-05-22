ref = FirebaseDatabase.getInstance().getReference("Event");
ref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for(DataSnapshot userSnapshot: dataSnapshot.getChildren()) {
            for(DataSnapshot eventSnapshot: userSnapshot.getChildren()) {
                eventInfo = eventSnapshot.getValue(EventInfo.class);
                Log.d("Event", eventSnapshot.getKey());
                Log.d("Event", eventSnapshot.child("title").getValue(String.class));
            }
        }
    }
    ...