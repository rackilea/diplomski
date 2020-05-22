public void onDataChange(DataSnapshot dataSnapshot) {
    for(DataSnapshot ds : dataSnapshot.getChildren()){
        mUserCheckData=mDatabaseRef.child(ds.getKey());
        array.add(new Post(mUserCheckData.child("imageString").toString(),mUserCheckData.child("Message").toString(),mUserCheckData.child("Username").toString()));
        Log.d("TAGPLS",mUserCheckData.child("imageString").toString());
    }
    customAdapter=new CustomAdapter(getActivity(),R.layout.item,array);
    list = view.findViewById(R.id.id_listView);
    list.setAdapter(customAdapter);
    customAdapter.notifyDataSetChanged();
}