@Override
public void onBindViewHolder(ContentViewHolder holder, int position) {
    String name = data.get(position);
    holder.dateText.setText(name);

    if (previousSelectedPosition == position) {
        main.setBackground(ContextCompat.getDrawable(context,R.drawable.date_range_selected_item_background));
        dateText.setTextColor(ContextCompat.getColor(context,R.color.colorPrimary));
    } else {
        // TODO: Configure the FrameLayout and TextView here for initial runtime as well as back to default
    }
}