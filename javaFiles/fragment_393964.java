DatabaseReference dbref = FirebaseDatabase().getInstance().getReference("Search History");
dbref.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
        for(DataSnapshot child : dataSnaphsot.getChildren()){
            //Link is the link from Firebase.
            String link = child.child("Link").getValue().toString();
        }
    }
    ...
}