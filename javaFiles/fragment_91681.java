ArrayList<HashMap<String, String >> data = new ArrayList<>();
        //I'm assuming you already feed your data, so you're not passing null like me here.

        cardlistview = findViewById(R.id.cardlistview);

        albumAdapter = new AlbumAdapter(your_arraysOfHashMap);
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getApplicationContext());
        cardlistview.setLayoutManager(mLayoutManager);
        cardlistview.setAdapter(albumAdapter);