public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

    PeopleToAdd peopleToAdd = dataSnapshot.getValue(PeopleToAdd.class);

    peopleToAdd.key = dataSnapshot.getKey();

    listItems.add(peopleToAdd);

    peopleToAddAdapter = new PeopleToAddAdapter(SetProject.this, listItems);
    recyclerView.setAdapter(peopleToAddAdapter);
    peopleToAddAdapter.notifyDataSetChanged();
}