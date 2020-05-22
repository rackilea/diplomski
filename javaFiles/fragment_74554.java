DatabaseReference ref=FirebaseDatabase.getInstance().getReference().child("Cat1");
ref.orderByChild("item_name").equalTo("item1").addSingleValueEventListener(new ValueEventListener(){
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {

        for(DataSnapshot datas : dataSnapshot.getChildren()){

        DatabaseReference refer=FirebaseDatabase.getInstance().getReference().child("Cat1");
        refer.orderByChild("date").equalTo(date).addSingleValueEventListener(new ValueEventListener(){

            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {

                if (dataSnapshot.exists()) {

                    for (Datasnapshot ds : dataSnapshot) {

                        List<Datasnapshot> list = new ArrayList<>();
                        list.add(ds);

                        //compare data and apply logic

                    }

                }
            }

            @Override
            public void onCancelled(FirebaseError firebaseError) {

            }
        });
    }

    @Override
    public void onCancelled(FirebaseError firebaseError) {

    }
});