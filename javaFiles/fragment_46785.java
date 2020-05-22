public void onBindViewHolder(ViewHolder holder, int position) {
    holder.myText.setOnClickListener(new View.OnClickListener() {
@Override
    public void onClick(View view) {
         itemClickListener.onRecyclerViewItemClicked(position);
         //itemClickListener is the Interface Reference Variable
    }
});
}