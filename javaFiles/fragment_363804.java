// Create an empty adapter since you don't have initial data
// (You may need to alter the constructor of your Adapter class 
//  to keep it from trying to process empty/null data so it doesn't break)
MyAdapter myAdapter = new MyAdapter(null);

// Set the Recyclerview's Adapter so it isn't skipped on the layout pass
myRecyclerView.setAdapter(myAdapter);