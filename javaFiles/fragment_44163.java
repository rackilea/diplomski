DatabaseReference rootRef = FirebaseDatabase.getInstance().getReference();
DatabaseReference dateRef = rootRef.child("Rajadriving").child("9-6-2018");
Query query = dateRef.orderByChild("phone").equalTo(searchedPhoneNumber);

for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
    Datastore upload = postSnapshot.getValue(Datastore.class);
    mUploads.add(upload);
}