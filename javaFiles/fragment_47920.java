@Override 
    public void onBindViewHolder(final ViewHolder holder, int position) {
        final String element = mDataset[position];

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               //your code 
            }
        });
    }