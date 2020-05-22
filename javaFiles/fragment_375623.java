final ListView listView = (ListView) findViewById(R.id.listView);
final ArrayList<String> friends = new ArrayList<String>();
players.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for (DataSnapshot player : dataSnapshot.getChildren()) {
            Log.i("player", player.getKey());
            friends.add(player.getKey());
        }
        ArrayAdapter arrayAdapter = new ArrayAdapter(MainActivity.this, android.R.layout.simple_list_item_1,
            friends);
        listView.setAdapter(arrayAdapter);
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
});