@Override
        public ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            ViewHolder viewHolder = super.onCreateViewHolder(parent, viewType);
            viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String key = firebaseRecyclerAdapter.getRef(mRecycler.getChildLayoutPosition(v)).getKey();
                    // do your magic here
                }
            });

            return viewHolder;
        }