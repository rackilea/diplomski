DatabaseReference nishi = FirebaseDatabase.getInstance().getReference("players");
    Query query = nishi.orderByChild("game_id").equalTo("-KweUgQj9sV01KvgbCu");
    query.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot snapshot) {
                List<Object> commentKeys = new ArrayList<>();
                for (DataSnapshot childSnapshot: snapshot.getChildren()) {
                    commentKeys.add(childSnapshot.getValue());
                }
                Log.d("Data:", commentKeys.toString());

            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });