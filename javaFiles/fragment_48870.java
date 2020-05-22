FCGames.addListenerForSingleValueEvent(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
        numGames = (int) dataSnapshot.getChildrenCount();
          ArrayList<String> openGames = new ArrayList<>();

           for(DataSnapshot ds : dataSnapshot.getChildren()) {
                gm = ds.getValue(GameMaker.class);
                openGames.add(gm.getUser1().getUserName());
            }
             //Pass the object to a method in your program to update UI.
            updateUi(openGames);
           //Reload the adapter!


        adapter.notifyDataSetChanged();

    }