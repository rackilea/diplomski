DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference scoreRef = rootRef.child("score");
ValueEventListener eventListener = new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        List<Score> list = new ArrayList<>();
        for(DataSnapshot ds : dataSnapshot.getChildren()) {
            Score s = ds.getValue(Score.class);
            String userId = s.getUserId();
            String score = s.getScore();
            Log.d("TAG", userId + " / " +  score);
            list.add(score);
        }
        ListView listView = (ListView) findViewById(R.id.list_view);
        ArrayAdapter arrayAdapter = new ArrayAdapter<>(getActivity(), android.R.layout.simple_list_item_1, list);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {}
};
scoreRef.addListenerForSingleValueEvent(eventListener);