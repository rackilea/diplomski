databaseReference.addValueEventListener(new ValueEventListener() {
ArrayList<Object> array = new ArrayList<>();
       @Override
       public void onDataChange(DataSnapshot dataSnapshot) {
           Log.i("snap", "onDataChange: " + dataSnapshot.getValue());

           for(DataSnapshot ds: dataSnapshot.getChildren()) {
               for(DataSnapshot team: ds.getChildren()) {

                   String key = team.getKey();

                   Log.i("my team", team.toString());


                   array.add(key);


               }
           }
        ArrayAdapter adapter = new ArrayAdapter(StatisticsActivity.this, android.R.layout.simple_list_item_1, array);
        listViewTeam.setAdapter(adapter);
        dataSnapshot.getValue();//I think this is not needed in your code.

       }

       @Override
       public void onCancelled(DatabaseError databaseError) {

       }
   });