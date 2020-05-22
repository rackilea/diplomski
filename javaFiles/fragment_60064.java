recyclerView = (RecyclerView) findViewById(R.id.recycerViewOrderNewItem);

    mAdapter = new NewOrderEntryAdapter(this,allItemsOfOrder);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(mAdapter);