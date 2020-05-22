mRecyclerView = (RecyclerView) viiew.findViewById(R.id.my_recycler_view);
mRecyclerView.setHasFixedSize(true);

mLayoutManager = new LinearLayoutManager(mContext);
mRecyclerView.setLayoutManager(mLayoutManager);

mAdapter = new RecyclerAdapter(newstitl,newsdat, newsbody);
mRecyclerView.setAdapter(mAdapter);