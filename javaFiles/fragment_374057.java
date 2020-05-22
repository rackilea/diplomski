recyclerView = (RecyclerView) findViewById(R.id.RVODetails);

    mAdapter = new ModuleAdapter(result);
    RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
    recyclerView.setLayoutManager(mLayoutManager);
    recyclerView.setItemAnimator(new DefaultItemAnimator());
    recyclerView.setAdapter(mAdapter);

}