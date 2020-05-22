final EventRecyclerAdapter adapter = new EventRecyclerAdapter(this);

            recyclerView.setAdapter(adapter);
            recyclerView.setLayoutManager(new LinearLayoutManager(this));

            // Set up the WordViewModel.
            mViewModel = ViewModelProviders.of(this).get(ValleyViewModel.class);
   mViewModel.getmCertainEvents(FILTERLEVEL).observe(this, new Observer<List<Events>>() {
                    @Override
                    public void onChanged(@Nullable final List<Events> events) {
                        // Update the cached copy of the words in the adapter.
                        adapter.setEvents(events);

                    }
                });