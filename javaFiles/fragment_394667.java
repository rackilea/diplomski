RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(this);
recyclerView.setLayoutManager(mLayoutManager);

showAdapter = new ShowsAdapter(this, shows);

recyclerView.setAdapter(showAdapter);