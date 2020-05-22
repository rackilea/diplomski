mDatabase.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            itemList.clear();
            // 1
            for (DataSnapshot ds : dataSnapshot.getChildren()) {
                    Score score = ds.getValue(Score.class);
            // 2
                    itemList.add("Date: " + score.getDate() + ", Time: " + score.getTime() + ". \nYou've chosen " + score.getCat1() + " as your range, " + score.getCat2() + " as sign of your equations and the time was " + score.getCat3() + ".\nYour score was " + score.getScore());
                }
            // 3
            adapter = new ArrayAdapter<String>(HistoryActivity.this,android.R.layout.simple_list_item_1, itemList);
            listView.setAdapter(adapter);
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });