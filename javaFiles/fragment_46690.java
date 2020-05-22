databaseReference.child("Tornei").addListenerForSingleValueEvent(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for(DataSnapshot datas: dataSnapshot.getChildren()){
               Creator.add(datas.child("nameCreator").getValue().toString());
    if(Creator.equals(data.getNameCreator())){
        registration = false;
    }else{
        registration = true;
    }
            }
        }
        @Override
        public void onCancelled(DatabaseError databaseError) {
        }
    });