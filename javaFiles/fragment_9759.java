DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference scoreRef = rootRef.child("score");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<String> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            String userId = ds.child("userId").getValue(String.class);
            String score = ds.child("score").getValue(String.class);
            list.add(userId + " / " +  score);
            Log.d("TAG", userId + " / " +  score);
        }
        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
scoreRef.addListenerForSingleValueEvent(eventListener);