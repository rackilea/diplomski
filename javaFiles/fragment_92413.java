@Override
    protected void onBindViewHolder(CheeseViewHolder holder, int position, Cheese model) {
     cheesesViewHolder myHolder = (cheesesViewHolder)holder;
     myHolder.cheese_name.setText(model.getCheeseName());
     myHolder. cheese_origin.setText(model.getCheeseOrigin());
     //and so on...
}