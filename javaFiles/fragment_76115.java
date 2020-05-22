public void onBindViewHolder(RecyclerViewHolders holder, int position) {
 holder.AppName.setText(itemList.get(position).getName());
 holder.AppButton.setImageDrawable(itemList.get(position).getPhoto());
 //this is where you set the background to transparent...
 holder.AppButton.setBackgroundColor(Color.TRANSPARENT);
}