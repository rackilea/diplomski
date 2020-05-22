@Override
    protected void populateViewHolder(MovieViewHolder viewHolder, final Movie model, final int position) {
        if(tvNoMovies.getVisibility()== View.VISIBLE){
            tvNoMovies.setVisibility(View.GONE);
        }
        viewHolder.tvMovieName.setText(model.getMovieName());
        viewHolder.address.setText(model.getAddress());
        viewHolder.phone.setText(model.getPhone());
        viewHolder.lit.setText(model.getLit());
        viewHolder.lon.setText(model.getLon());
        Picasso.with(MainActivity.this).load(model.getMoviePoster()).into(viewHolder.ivMoviePoster);

        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, DetailActivity.class);
                //intent.putExtra("model", model);
                intent.putExtra("latitude", model.getLit());
                intent.putExtra("longitude", model.getLon());

                startActivity(intent);
            }
        });
// all your stuff

    }