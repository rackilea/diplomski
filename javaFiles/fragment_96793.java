peopleRef.orderByChild("age").equalTo(age).addValueEventListener(new ValueEventListener(){
        @Override
        public void onDataChange(DataSnapshot snapshot) {
            for(DataSnapshot dataSnapshot : snapshot.getChildren())
            {
                String name = dataSnapshot.child("name").getValue().toString();
                nameArray.add(name);
            }
            showNames();
        }
});