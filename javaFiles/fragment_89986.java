onCreate() {
...    
bagLotNumberAdapter = new BagLotNumberAdapter(this, bagLotNumbers);

            RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
            recyclerView.setLayoutManager(mLayoutManager);
            recyclerView.setAdapter(bagLotNumberAdapter);

            ItemTouchHelper itemTouchHelper = new
                    ItemTouchHelper(new SwipeToDeleteBagLotNumberCallback(bagLotNumberAdapter));
            itemTouchHelper.attachToRecyclerView(recyclerView);
    ...
    }