userRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        for (DataSnapshot propertySnapshot: dataSnapshot.getChildren()) {
            System.out.println(propertySnapshot.getKey()+": "+propertySnapshot.getValue(String.class));
        }
    }