@Override
public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
    if (!(holder instanceof MyViewHolder)) {
        return;
    }
    int itemPosition = position - position / ITEM_PER_AD ; // need to adjust to get the list item position excluding ads
}