@Override
    public void onBindViewHolder(ViewHolder holder, int position) {
        //holder.textView.setText(titles[position]);

        holder.title.setText(events.getTitle());
        holder.time.setText(events.getTime());
        holder.places.setText(events.getPlacesLeft());

            holder.yourview.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) 
                {
                    //access from here
            Toast.makeText(yourActivity.this,holder.yourview.getText().toString(), Toast.LENGTH_SHORT).show();

                }
            });

    }