String uid = FirebaseAuth.getInstance().getCurrentUser().getUid();
DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference friendsRef = rootRef.child("users").child(uid).child("friends");
ValueEventListener valueEventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String friendUid = ds.getKey();

            DatabaseReference friendUidRef = rootRef.child("users").child(friendUid);
            ValueEventListener eventListener = new ValueEventListener() {
                @Override
                public void onDataChange(DataSnapshot dataSnapshot) {
                    for(DataSnapshot ds : dataSnapshot.getChildren()) {
                        String firstName = ds.child("firstName").getValue(String.class);
                        String surname = ds.child("surname").getValue(String.class);
                        String friendName = firstName + " " + surname;
                        Log.d(TAG, friendName);

                        DatabaseReference friendUidWorkoutsRef = rootRef.child("workouts").child(friendUid);
                        ValueEventListener listener = new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                List<FriendWorkout > workouts = new ArrayList<>(); //List added
                                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                                    Workout workout = ds.getValue(Workout.class);
                                    Log.d(TAG, workout.getWorkoutName());

                                    //Create an object of FriendWorkout as needed
                                    FriendWorkout friendWorkout = new FriendWorkout(friendName, workout);
                                    workouts.add(friendWorkout); //Add object to the list
                                }
                                ListView listView = (ListView) findViewById(R.id.list_view);
                                ArrayAdapter<Data> arrayAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, list);
                                listView.setAdapter(arrayAdapter); //Set the adapter
                            }

                            @Override
                            public void onCancelled(@NonNull DatabaseError databaseError) {
                                Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
                            }
                        };
                        friendUidWorkoutsRef.addListenerForSingleValueEvent(listener);
                    }
                }

                @Override
                public void onCancelled(@NonNull DatabaseError databaseError) {
                    Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
                }
            };
            friendUidRef.addListenerForSingleValueEvent(eventListener);
        }
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        Log.d(TAG, databaseError.getMessage()); //Don't ignore errors!
    }
};
friendsRef.addListenerForSingleValueEvent(valueEventListener);