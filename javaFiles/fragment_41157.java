eventListener = databaseReference.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(@NonNull DataSnapshot dataSnapshot) {

        //myFoodList.clear();

        for(DataSnapshot itemSnapshot:dataSnapshot.getChildren()){

            FoodData foodData = itemSnapshot.getValue(FoodData.class);
            myFoodList.add(foodData);
        }
        final MyAdapter myAdapter = new MyAdapter(RecipeList.this,myFoodList);
        mRecyclerView.setAdapter(myAdapter);
        myAdapter.notifyDataSetChanged();
        progressDialog.dismiss();
    }

    @Override
    public void onCancelled(@NonNull DatabaseError databaseError) {
        progressDialog.dismiss();
    }
});