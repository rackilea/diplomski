recyclerView = findViewById(R.id.recyclerView);
imageAdapter = new ImageAdapter(this);

recyclerView.setHasFixedSize(true);
recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.HORIZONTAL))
recyclerView.addItemDecoration(new DividerItemDecoration(this,
                DividerItemDecoration.VERTICAL))
recyclerView.setLayoutManager(new GridLayoutManager(HomepageActivity.this,2));
recyclerView.setAdapter(imageAdapter);