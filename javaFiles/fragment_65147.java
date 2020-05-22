public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    PeopleToAdd peopleToAdd = dataSnapshot.getValue(PeopleToAdd.class);
    listItems.add(peopleToAdd);

    test = dataSnapshot.getKey();
    Log.d(TAG, test);
    peopleToAddAdapter = new PeopleToAddAdapter(SetProject.this, listItems);
    recyclerView.setAdapter(peopleToAddAdapter);
    peopleToAddAdapter.notifyDataSetChanged();
}