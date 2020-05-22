List<University> universityList = new ArrayList<>();
myRef.addChildEventListener(new ChildEventListener() {
    @Override
    public void onChildAdded(DataSnapshot dataSnapshot, String s) {
         University university = dataSnapshot.getValue(University.class);
         universityList.add(university);
         Log.i(TAG,"add university name = " + university.name);
         ...
    }
    ...
}