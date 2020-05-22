queryRef.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        for (DataSnapshot child: snapshot.getChildren()) {
            String username = (String) child.child("username").getValue(); 
            usernames.add(username); 
        }
        ArrayAdapter<String> adapter = new ArrayAdapter<>(
            EditFriendsActivity.this,
            android.R.layout.simple_list_item_multiple_choice, 
            usernames);

        mFriendsList.setAdapter(adapter); 
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {
        Log.e(TAG, firebaseError.getMessage());
    }
});