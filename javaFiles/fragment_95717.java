public void onDataChange(DataSnapshot dataSnapshot) {
    List<String> names = new LinkedList<String>();
    for (DataSnapshot postSnapshot: dataSnapshot.getChildren()) {
        String key = postSnapshot.getKey();
        String name = postSnapshot.child("easy/name").getValue(String.class);
        names.add(0, name);
    }
}