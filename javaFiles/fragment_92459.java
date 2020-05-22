List<University> universityList = new ArrayList<>();
myRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot snapshot) {
        universityList.clear();
        for (DataSnapshot postSnapshot: snapshot.getChildren()) {
            University university = postSnapshot.getValue(University.class);
            universityList.add(university);

            // here you can access to name property like university.name

        }
    }

    @Override
    public void onCancelled(DatabaseError databaseError) {
        System.out.println("The read failed: " + firebaseError.getMessage());
    }
});