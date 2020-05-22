myRef.addValueEventListener(new ValueEventListener() {
    @Override
    public void onDataChange(DataSnapshot dataSnapshot) {
           list.clear();
        for (DataSnapshot childDataSnapshot : dataSnapshot.getChildren()) {
         ExpenseTestModel     expenseTestModelValues = (ExpenseTestModel) dataSnapshot.getValue(ExpenseTestModel.class);
         list.add(expenseTestModelValues);
        }
     // Now  print size of list
    Log.e("list size",":"+list.size()); 
    }
    @Override
    public void onCancelled(DatabaseError databaseError) {
        throw databaseError.toException();
    }
});