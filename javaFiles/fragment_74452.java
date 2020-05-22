// create viewholder using adapter - if you have custom view type use it instead of 0
RecyclerView.ViewHolder vh = recyclerView.getAdapter().createViewHolder(recyclerView, 0);
// measure item view using recycler views layout manager
recyclerView.getLayoutManager().measureChildWithMargins(vh.itemView, 0, 0);
// now carry over viewholder size onto recyclerView, for example show 5 items
recyclerView.getLayoutParams().height = vh.itemView.getMeasuredHeight() * 5;
// finally throw created viewholder into scrap pool so it can be reused
recyclerView.getRecycledViewPool().putRecycledView(vh);