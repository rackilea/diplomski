ArrayList<Dress> mItems = new ArrayList<>();
...

if (task.isSuccessful()) {
    for (QueryDocumentSnapshot snapshot : Objects.requireNonNull(task.getResult())) {
        mItems.add(new Dress(snapshot));                
    }
    recyclerView.setAdapter(new dressAdapter(mItems));
 }