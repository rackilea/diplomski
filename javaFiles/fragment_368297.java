listViewLeaderBoard = (ListView) findViewById(R.id.listView_leader_board);

    reference = FirebaseDatabase.getInstance().getReference("score");

    leaderBoards = new ArrayList<>();

    reference.addValueEventListener(new ValueEventListener() {
        @Override
        public void onDataChange(DataSnapshot dataSnapshot) {
            for (DataSnapshot postSnapshot : dataSnapshot.getChildren()){
                LeaderBoard leaderBoard = postSnapshot.getValue(LeaderBoard.class);
                leaderBoards.add(leaderBoard);
         CustomLeaderBoardAdapter adapter = new CustomLeaderBoardAdapter(getApplicationContext(),R.layout.leader_board_list_layout,leaderBoards);
    listViewLeaderBoard.setAdapter(adapter);
    adapter.notifyDataSetChanged();
            }
        }

        @Override
        public void onCancelled(DatabaseError databaseError) {

        }
    });