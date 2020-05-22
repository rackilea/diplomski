@Override
public void onBindViewHolder(StarCountHolder holder, int position) {
    StarCount model = starCounts.get(position);
    Picasso.with(context)
            .load("http://"+model.getImagePath())
            .into(holder.starImage);
    holder.actorName.setText(model.getName());
    holder.counts.setText(""+model.getCount());
    if(selectedPosition == position){
       // do whatever you want to do to make it selected.
    }
}