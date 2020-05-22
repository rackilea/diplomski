@Override
    protected void onStart() {
        super.onStart();
        //   mAuth.addAuthStateListener(mAuthLitsener);

        FirebaseRecyclerAdapter<Event,EventViewHolder> firebaseRecyclerAdapter_ = new FirebaseRecyclerAdapter<Event, GraduationListActivity.EventViewHolder>(Event.class,
                R.layout.item_event_view,
                GraduationListActivity.EventViewHolder.class,
                queryRef) {
            @Override
            protected void populateViewHolder(GraduationListActivity.EventViewHolder viewHolder, final Event model, final int position) {
                final String key_post = getRef(position).getKey();
                viewHolder.setEventLocation(model.getEventlocation());
                viewHolder.setEventName(model.getEventName());
                viewHolder.setEventType(model.getEventType());
                viewHolder.mView.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        // Toast.makeText(EventViewActivity.this,"This is : "+position,Toast.LENGTH_LONG).show();

                        Intent loadMainActivity = new Intent(GraduationListActivity.this,MainActivity.class);
                        loadMainActivity.putExtra(EventViewHolder.KEY_PARTY_NAME, model.getEventName());
                        startActivity(loadMainActivity);

                    }
                });





            }
        };

        mRecyclerview_event_view.setAdapter(firebaseRecyclerAdapter_);


    }