@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
     .....
    //listView.setAdapter(adapter); remove this line from here 
     .......
        @Override
        public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Blog blog = dataSnapshot.getValue(Blog.class);//also make sure this line is returning a valid result which can be cast to Blog Class
                adapter.add(blog);
                //listView.setAdapter(adapter); or you can call here but not good approach


            }
        .................

    });
 listView.setAdapter(adapter); // call it here

}
}